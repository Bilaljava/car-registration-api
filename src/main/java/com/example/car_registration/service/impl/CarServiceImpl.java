package com.example.car_registration.service.impl;

import com.example.car_registration.dto.CarDto;
import com.example.car_registration.dto.CreateCarRequest;
import com.example.car_registration.entity.Car;

import com.example.car_registration.mapper.CarMapper;
import com.example.car_registration.repository.CarRepository;
import com.example.car_registration.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;



    @Override
    public CarDto registerCar(CreateCarRequest request) {
        if (checkCarExists(request.getPlateNumber())) {

            throw new IllegalArgumentException("Car with plate number "
                    + request.getPlateNumber() + " already exists.");

        }
        Car car = carMapper.toCarEntity(request);


        Car savedCar = carRepository.save(car);
        return carMapper.toCarDto(savedCar);
    }

    @Override
    public boolean checkCarExists(String plateNumber) {
        return carRepository.findByPlateNumber(plateNumber).isPresent();
    }

    @Override
    public List<CarDto> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(carMapper::toCarDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CarDto> findCarByPlateNumber(String plateNumber) {
        Optional<Car> carOptional = carRepository.findByPlateNumber(plateNumber);
        return carOptional.map(carMapper::toCarDto);


    }
}
