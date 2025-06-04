package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.*;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.model.mapper.PatientMapper;
import com.example.prescription_generation.model.mapper.PrescriptionMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.repository.PrescriptionRepository;
import com.example.prescription_generation.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

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

    @GetMapping("/Prescription-create")
    public String showCreateForm(Model model) {
        PrescriptionDTO prescriptionDTO = new PrescriptionDTO();
        List<Patient> patients = patientRepository.findAll() ;
        model.addAttribute("patients", patients);
        model.addAttribute("prescription", prescriptionDTO);
        return "prescription_creation";
    }

    @PostMapping(value = "/Prescription-create")
    public String createPrescription(@ModelAttribute("prescription") PrescriptionDTO prescriptionDTO) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String loggedInUsername = auth.getName();


        Doctor doctor = doctorRepository.findByEmail(loggedInUsername)
                .orElseThrow(() -> new RuntimeException("Logged-in doc not found: " + loggedInUsername));
        prescriptionDTO.setDoctor_id(doctor.getId());
        prescriptionDTO.setPrescribedBy(doctor.getEmail());

        prescriptionService.savePrescription(prescriptionDTO);


        return "redirect:/dashboard?success=true";
    }
    @GetMapping("/Prescription-list")
    public String showPrescriptionList(Model model, Authentication auth) {
        model.addAttribute("username", auth.getName());
        List<PrescriptionDTO> prescriptions = prescriptionService.getPrescriptionsByLoggedInDoctor();
        model.addAttribute("prescriptions", prescriptions);
        return "prescription_table";
    }

    @GetMapping("/Prescription-Update/{id}")
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

    @PostMapping("/Prescription-Update/{id}")
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

        return "redirect:/dashboard?updateSuccess=true";
    }

    @GetMapping("/Prescription-Delete/{id}")
    public String deletePrescription(@PathVariable("id") Long id) {
        prescriptionService.deleteById(id);
        return "redirect:/dashboard?deleteSuccess=true";
    }

    @GetMapping("/reports/daywise-prescription")
    public String showDayWiseReport(Model model) {
        List<DayWisePrescriptionCountDTO> reportData = prescriptionService.getDayWisePrescriptionCount();
        model.addAttribute("reportData", reportData);
        return "prescription_daywise_report";  // resources/templates/prescription_daywise_report.html
    }

    @GetMapping("/Consume-External-API")
    public String showConsumeExternalAPI(Model model) {

        try {
            model.addAttribute("externalApiCalls", externalApiCallService.getAllPosts());
            return "external_api_response";
        }catch (HttpClientErrorException.NotFound ex) {
            model.addAttribute("externalApiCalls", Collections.emptyList());
            model.addAttribute("apiError", "কোনো ডেটা পাওয়া যায়নি (404)।");
            return "redirect:/dashboard?notFound=true";
        }
    }
}
