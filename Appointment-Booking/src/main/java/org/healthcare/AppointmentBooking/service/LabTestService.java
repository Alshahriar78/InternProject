package org.healthcare.AppointmentBooking.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.healthcare.AppointmentBooking.model.dto.LabTestDTO;
import org.healthcare.AppointmentBooking.model.entity.Lab;
import org.healthcare.AppointmentBooking.model.entity.LabTest;
import org.healthcare.AppointmentBooking.model.mapper.LabTestMapper;
import org.healthcare.AppointmentBooking.repository.LabRepository;
import org.healthcare.AppointmentBooking.repository.LabTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LabTestService {

    private final LabRepository labRepository;

    @Autowired
    private LabTestRepository labTestRepository;
    LabTestMapper labTestMapper;
    @PersistenceContext
    private EntityManager entityManager;

    public LabTestDTO createLabTest(LabTestDTO labTestDTO) {
        LabTest labTest = LabTestMapper.toEntity(labTestDTO);
//        Lab lab = labRepository.findById(labTestDTO.getLabId()).orElseThrow();
        LabTest saved = labTestRepository.save(labTest);
        return LabTestMapper.toDto(saved);
    }

    public List<LabTestDTO> getAllLabTests() {
        List<LabTest> allTests = labTestRepository.findAll();
        return Collections.singletonList(LabTestMapper.toDto((LabTest) allTests));
    }

    public List<LabTest> searchLabTest(String keyword) {
        return entityManager.createQuery(
                        "SELECT lt FROM LabTest lt WHERE UPPER(lt.labTestName) LIKE UPPER(:search) ESCAPE '\\'",
                        LabTest.class)
                .setParameter("search", "%" + keyword + "%")
                .getResultList();
    }
}

