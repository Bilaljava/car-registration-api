package com.example.car_registration.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequest {


    @NotBlank(message = "Plate number cannot be blank")
    @Size(min = 6, max = 15, message = "Plate number must be between 6 and 15 characters")

    private String plateNumber;
}
