package com.example.car_registration.controller;


import com.example.car_registration.dto.CarDto;
import com.example.car_registration.dto.CreateCarRequest;
import com.example.car_registration.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
@RequiredArgsConstructor

public class CarController {
    private final CarService carService;

    @PostMapping
    public ResponseEntity<CarDto> registerCar(@Valid @RequestBody CreateCarRequest request) {
        CarDto createdCar = carService.registerCar(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }


    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAllCars();
        return ResponseEntity.ok(cars);
    }


    @GetMapping("/{plateNumber}")
    public ResponseEntity<CarDto> getCarByPlateNumber(@PathVariable String plateNumber) {
        Optional<CarDto> carDtoOptional = carService.findCarByPlateNumber(plateNumber);
        if (carDtoOptional.isPresent()) {
            return ResponseEntity.ok(carDtoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

        @GetMapping("/exists/{plateNumber}")
        public ResponseEntity<Boolean> checkCarExists(@PathVariable String plateNumber) {
            boolean exists = carService.checkCarExists(plateNumber);
            return ResponseEntity.ok(exists);

    }

}

