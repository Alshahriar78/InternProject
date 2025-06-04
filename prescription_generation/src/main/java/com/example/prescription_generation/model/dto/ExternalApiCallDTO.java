package com.example.prescription_generation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalApiCallDTO {
        private Long id;
        private String title;
        private String completed;

}
