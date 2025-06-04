package com.example.prescription_generation.model.dto;

import java.time.LocalDate;

public class DayWisePrescriptionCountDTO {

    private LocalDate day;
    private Long count;

    public DayWisePrescriptionCountDTO(LocalDate day, Long count) {
        this.day = day;
        this.count = count;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
