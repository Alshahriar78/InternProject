package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.*;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.model.mapper.PatientMapper;
import com.example.prescription_generation.model.mapper.PrescriptionMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.repository.PrescriptionRepository;
import com.example.prescription_generation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller
public class WebController {

    @Autowired
    private UserRegistrationService userRegistrationService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMapper patientMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PrescriptionRepository prescriptionRepository;
    @Autowired
    private PrescriptionMapper prescriptionMapper;
    @Autowired
    private ExternalApiCallService externalApiCallService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @PostMapping("/register")
    public String registerUser(
            @Valid
            @RequestParam("userType") String userType,
            @RequestParam("name") String name,
            @RequestParam("username") String username,
            @RequestParam("email") String email,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("password") String password,
            @RequestParam(value = "specialist", required = false) String specialist,
            @RequestParam(value = "age", required = false) Integer age,
            @RequestParam(value = "gender", required = false) String gender,
            @RequestParam(value = "bloodGroup", required = false) String bloodGroup,
            @RequestParam(value = "address", required = false) String address,
            RedirectAttributes redirectAttributes) {

        try {

            if ("doctor".equals(userType)) {
                DoctorDTO doctorDTO = new DoctorDTO();
                doctorDTO.setName(name);
                doctorDTO.setEmail(email);
                doctorDTO.setPhoneNumber(phoneNumber);
                doctorDTO.setPassword(password);
                doctorDTO.setSpecialist(specialist);
                doctorDTO.setRole("DOCTOR");

                userRegistrationService.registerDoctor(doctorDTO);
            } else if ("patient".equals(userType)) {
                PatientDTO patientDTO = new PatientDTO();
                patientDTO.setName(name);
                patientDTO.setEmail(email);
                patientDTO.setPhoneNumber(phoneNumber);
                patientDTO.setPassword(password);
                patientDTO.setAge(age != null ? age : 0);
                patientDTO.setGender(gender);
                patientDTO.setBloodGroup(bloodGroup);
                patientDTO.setAddress(address);
                patientDTO.setRole("PATIENT");
                userRegistrationService.registerPatient(patientDTO);
            }

            redirectAttributes.addAttribute("success", "true");
            return "redirect:/login";
        } catch (Exception e) {

            redirectAttributes.addAttribute("error", e.getMessage());
            return "redirect:/register";
        }
    }


    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        return "dashboard";
    }

    @GetMapping("/prescription-create")
    public String showCreateForm(Model model) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        List<Patient> patients = patientRepository.findAll() ;
        model.addAttribute("patients", patients);
        model.addAttribute("prescription", prescriptionDTO);
        return "prescription_creation";
    }

    @PostMapping( "/prescription-create")
    public String createPrescription( @Valid
            @ModelAttribute("prescription") PrescriptionDTO prescriptionDTO,
            BindingResult bindingResult,
            Model model

    ) {
        if (bindingResult.hasErrors()) {

            model.addAttribute("patients", patientRepository.findAll());
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Validation error: " + error);
            });

            return "prescription_creation";
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = auth.getName();


        Doctor doctor = doctorRepository.findByEmail(loggedInUsername)
                .orElseThrow(() -> new RuntimeException("Logged-in doc not found: " + loggedInUsername));
        prescriptionDTO.setDoctor_id(doctor.getId());
        prescriptionDTO.setPrescribedBy(doctor.getEmail());

        prescriptionService.savePrescription(prescriptionDTO);


        return "redirect:/prescription-list?createSuccess=true";
    }
    @GetMapping("/prescription-list")
    public String showPrescriptionList(Model model, Authentication auth) {
        model.addAttribute("username", auth.getName());
        List<PrescriptionDTO> prescriptions = prescriptionService.getLastMonthPrescription();
        model.addAttribute("prescriptions", prescriptions);
        return "prescription_table";
    }

    @GetMapping("/search-by-date")
    public String getByDateRange(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to,
            Model model
    ) {

        List<PrescriptionDTO> prescriptions =  prescriptionService.getPrescriptionSearchByFromDateToDate(from,to);

        model.addAttribute("prescriptions", prescriptions);

        return "seach_prescription";
    }

    @GetMapping("/prescription-update/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        PrescriptionDTO dto = prescriptionService.getPrescriptionById(id);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInEmail = auth.getName();
        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doc not found: " + loggedInEmail));


        dto.setDoctor_id(doctor.getId());
        model.addAttribute("prescription", dto);

        model.addAttribute("patients", patientRepository.findAll());

        return "prescription_edit";
    }

    @PostMapping("/prescription-update/{id}")
    public String updatePrescription(@PathVariable("id") Long id,
                                     @Valid @ModelAttribute("prescription") PrescriptionDTO prescriptionDTO,
                                     BindingResult bindingResult,
                                     Model model) {
        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(error -> {
                System.out.println("Validation error: " + error);
            });

            model.addAttribute("patients", patientRepository.findAll());
            return "prescription_edit";
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInEmail = auth.getName();
        Doctor doctor = doctorRepository.findByEmail(loggedInEmail)
                .orElseThrow(() -> new RuntimeException("Logged-in doc not found: " + loggedInEmail));

        prescriptionService.updatePrescription(id, prescriptionDTO);

        return "redirect:/prescription-list?updateSuccess=true";
    }

    @GetMapping("/prescription-delete/{id}")
    public String deletePrescription(@PathVariable("id") Long id) {
        prescriptionService.deleteById(id);
        return "redirect:/prescription-list?deleteSuccess=true";
    }

    @GetMapping("/reports/day-wise-prescription")
    public String showDayWiseReport(Model model) {
        List<DayWisePrescriptionCountDTO> reportData = prescriptionService.getDayWisePrescriptionCount();
        model.addAttribute("reportData", reportData);
        return "prescription_daywise_report";  // resources/templates/prescription_daywise_report.html
    }

    @GetMapping("/consume-external-API")
    public String showConsumeExternalAPI(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            Model model) {

        try {
            List<ExternalApiCallDTO> allData = externalApiCallService.getAllPosts();

            int totalItems = allData.size();
            int totalPages = (int) Math.ceil((double) totalItems / size);
            int start = (page - 1) * size;
            int end = Math.min(start + size, totalItems);

            if (start > totalItems) {
                page = 1;
                start = 0;
                end = Math.min(size, totalItems);
            }

            List<ExternalApiCallDTO> pagedList = allData.subList(start, end);

            model.addAttribute("externalApiCalls", pagedList);
            model.addAttribute("currentPage", page);
            model.addAttribute("totalPages", totalPages);

            return "external_api_response";

        } catch (HttpClientErrorException.NotFound ex) {
            model.addAttribute("externalApiCalls", Collections.emptyList());
            model.addAttribute("apiError", "Found No DATA");
            return "redirect:/dashboard?notFound=true";
        }
    }

}
