package com.example.prescription_generation.config;

import com.example.prescription_generation.model.entity.Muser.Doctor;
import com.example.prescription_generation.model.entity.Muser.Patient;
import com.example.prescription_generation.model.entity.precription.Prescription;
import com.example.prescription_generation.repository.DoctorRepository;
import com.example.prescription_generation.repository.PatientRepository;
import com.example.prescription_generation.repository.PrescriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;
        private final PrescriptionRepository prescriptionRepository;

        @Override
    public void run(String... args) throws Exception {
                String password = "password";

            Doctor doctor = new Doctor();
            doctor.setName("Dr. John Doe");
            doctor.setEmail("doctor@example.com");
            doctor.setPhoneNumber("1234567890");
            doctor.setPassword(passwordEncoder.encode(password));
            doctor.setRole("DOCTOR");
            doctor.setEnabled(true);
            doctor.setSpecialist("Cardiologist");
            
            doctorRepository.save(doctor);
            
            System.out.println("Test doctor created: " + doctor.getEmail());

            Doctor doctor2 = new Doctor();
            doctor2.setName("Dr. <NAME>");
            doctor2.setEmail("doctor2@example.com");
            doctor2.setPhoneNumber("123456789");
            doctor2.setPassword(passwordEncoder.encode(password));
            doctor2.setRole("DOCTOR");
            doctor2.setEnabled(true);
            doctor2.setSpecialist("Cardiologist");

            doctorRepository.save(doctor2);



            Doctor doctor3 = new Doctor();
            doctor3.setName("Dr. <3>");
            doctor3.setEmail("doctor3@example.com");
            doctor3.setPhoneNumber("12345678");
            doctor3.setPassword(passwordEncoder.encode(password));
            doctor3.setRole("DOCTOR");
            doctor3.setEnabled(true);
            doctor3.setSpecialist("Cardiologist");

            doctorRepository.save(doctor3);
            System.out.println("Test doctor created: " + doctor3.getEmail());

            System.out.println("ALL doctor Password is : " +password);

        


            Patient patient = new Patient();
            patient.setName("Jane Smith");
            patient.setEmail("patient@example.com");
            patient.setPhoneNumber("0987654321");
            patient.setPassword(passwordEncoder.encode(password));
            patient.setRole("PATIENT");
            patient.setEnabled(true);
            patient.setAge(30);
            patient.setGender("Female");
            patient.setBloodGroup("O+");
            patient.setAddress("Mokamtola, Bogra City");
            
            patientRepository.save(patient);
            
            System.out.println("Test patient created: " + patient.getEmail());


            Patient patient2 = new Patient();
            patient2.setName("Fane Smith");
            patient2.setEmail("patient@2example.com");
            patient2.setPhoneNumber("09876543210");
            patient2.setPassword(passwordEncoder.encode(password));
            patient2.setRole("PATIENT");
            patient2.setEnabled(true);
            patient2.setAge(30);
            patient2.setGender("Female");
            patient2.setBloodGroup("O+");
            patient2.setAddress("Mokamtola, Bogra City");

            patientRepository.save(patient2);

            System.out.println("Test patient created: " + patient2.getEmail());

            Patient patient3 = new Patient();
            patient3.setName("C");
            patient3.setEmail("patient@3example.com");
            patient3.setPhoneNumber("098765432231");
            patient3.setPassword(passwordEncoder.encode(password));
            patient3.setRole("PATIENT");
            patient3.setEnabled(true);
            patient3.setAge(30);
            patient3.setGender("Female");
            patient3.setBloodGroup("O+");
            patient3.setAddress("Mokamtola, Bogra City");

            Patient patient4 = new Patient();
            patient4.setName("C");
            patient4.setEmail("patient@3example.com");
            patient4.setPhoneNumber("098765432231");
            patient4.setPassword(passwordEncoder.encode(password));
            patient4.setRole("PATIENT");
            patient4.setEnabled(true);
            patient4.setAge(30);
            patient4.setGender("Female");
            patient4.setBloodGroup("O+");
            patient4.setAddress("Mokamtola, Bogra City");

            patientRepository.save(patient3);

            System.out.println("Test patient created: " + patient3.getEmail());

            System.out.println("All USers password: " +password);



            Prescription prescription = new Prescription();
            prescription.setPrescriptionDate(LocalDate.of(2025, 6, 1));
            prescription.setDiagonosis("Fever");
            prescription.setMedicines("Napa ");
            prescription.setNextVisitDate(LocalDate.of(2025, 6, 10));
            prescription.setPatient(patient);
            prescription.setDoctor(doctor);
            prescription.setPrescribedBy(doctor.getName());
            prescription.setPatientName(patient.getName());

            prescriptionRepository.save(prescription);

            Prescription prescription2 = new Prescription();
            prescription2.setPrescriptionDate(LocalDate.of(2025, 6, 2));
            prescription2.setDiagonosis("Allege");
            prescription2.setMedicines("Rupin ");
            prescription2.setNextVisitDate(LocalDate.of(2025, 6, 10));
            prescription2.setPatient(patient2);
            prescription2.setDoctor(doctor);
            prescription2.setPrescribedBy(doctor.getName());
            prescription2.setPatientName(patient.getName());

            prescriptionRepository.save(prescription2);

            Prescription prescription3 = new Prescription();
            prescription3.setPrescriptionDate(LocalDate.of(2025, 6, 3));
            prescription3.setDiagonosis("Heart Decease");
            prescription3.setMedicines("Bomap 10 mg ");
            prescription3.setNextVisitDate(LocalDate.of(2025, 6, 10));
            prescription3.setPatient(patient3);
            prescription3.setDoctor(doctor);
            prescription3.setPrescribedBy(doctor.getName());
            prescription3.setPatientName(patient.getName());


            prescriptionRepository.save(prescription3);

            Prescription prescription4 = new Prescription();
            prescription4.setPrescriptionDate(LocalDate.of(2025, 6, 4));
            prescription4.setDiagonosis("Lunge Damage ");
            prescription4.setMedicines("Bopam 10 mg ");
            prescription4.setNextVisitDate(LocalDate.of(2025, 6, 10));
            prescription4.setPatient(patient3);
            prescription4.setDoctor(doctor);
            prescription4.setPrescribedBy(doctor.getName());
            prescription4.setPatientName(patient.getName());

                prescriptionRepository.save(prescription4);
    }

}