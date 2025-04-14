package com.example.car_registration.service;

import com.example.car_registration.dto.CarDto;
import com.example.car_registration.dto.CreateCarRequest;


import java.util.List;
import java.util.Optional;

public interface CarService {
    CarDto registerCar(CreateCarRequest request);

    boolean checkCarExists(String plateNumber);
    List<CarDto> getAllCars();


    Optional<CarDto> findCarByPlateNumber(String plateNumber);

}
