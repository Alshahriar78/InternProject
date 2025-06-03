package com.example.prescription_generation.controllers;

import com.example.prescription_generation.model.dto.DoctorDTO;
import com.example.prescription_generation.model.dto.PatientDTO;
import com.example.prescription_generation.model.dto.PrescriptionDTO;
import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.mapper.DoctorMapper;
import com.example.prescription_generation.model.mapper.PatientMapper;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.service.DoctorService;
import com.example.prescription_generation.service.PatientService;
import com.example.prescription_generation.service.PrescriptionService;
import com.example.prescription_generation.service.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                doctorDTO.setUsername(username);
//                doctor.setEmail(email);
                doctorDTO.setPhoneNumber(phoneNumber);
                doctorDTO.setPassword(password);
                doctorDTO.setSpecialist(specialist);

                userRegistrationService.registerDoctor(doctorDTO);
            } else if ("patient".equals(userType)) {
                PatientDTO patientDTO = new PatientDTO();
                patientDTO.setName(name);
                patientDTO.setUsername(username);
                patientDTO.setEmail(email);
                patientDTO.setPhoneNumber(phoneNumber);
                patientDTO.setPassword(password);
                patientDTO.setAge(age != null ? age : 0);
                patientDTO.setGender(gender);
                patientDTO.setBloodGroup(bloodGroup);
                patientDTO.setAddress(address);

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
}
