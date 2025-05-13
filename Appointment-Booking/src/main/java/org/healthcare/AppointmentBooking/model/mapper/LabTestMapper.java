package org.healthcare.AppointmentBooking.model.mapper;

import org.healthcare.AppointmentBooking.model.dto.LabTestDTO;
import org.healthcare.AppointmentBooking.model.entity.LabTest;

public class LabTestMapper {

    public static LabTest toEntity(LabTestDTO dto) {
        if (dto == null) return null;

        LabTest entity = new LabTest();
        entity.setLabTestName(dto.getLabTestName());
        entity.setLabTestDescription(dto.getLabTestDescription());
        entity.setLabTestPrice(dto.getLabTestPrice());
        entity.setLabTestImageUrl(dto.getLabTestImageUrl());
        return entity;
    }

    public static LabTestDTO toDto(LabTest entity) {
        if (entity == null) return null;

        LabTestDTO dto = new LabTestDTO();
        dto.setLabTestName(entity.getLabTestName());
        dto.setLabTestDescription(entity.getLabTestDescription());
        dto.setLabTestPrice(entity.getLabTestPrice());
        dto.setLabTestImageUrl(entity.getLabTestImageUrl());
        return dto;
    }

}

