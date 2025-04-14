package com.example.car_registration.mapper;


import com.example.car_registration.dto.CarDto;
import com.example.car_registration.dto.CreateCarRequest;
import com.example.car_registration.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

        public CarDto toCarDto(Car car) {
            if (car == null) {
                return null;
            }
            return new CarDto(
                    car.getId(),
                    car.getPlateNumber()
            );
        }

    public Car toCarEntity(CreateCarRequest request) {
        if (request == null) {
            return null;
        }
        return Car.builder()
                .plateNumber(request.getPlateNumber())
                .build();

    }
}

