package ric.masters.carservice.service;


import ric.masters.carservice.entity.Car;
import ric.masters.carservice.entity.Detail;


import java.util.List;

public interface CarService {
    Car getCarByCarId(long carId);

    Car getCarByVinCode(String vinCode);

    Car getCarByStateNumber(String stateNumber);

    List<Car> getAllCars();

    Car createCar(Car createdCar);

    Car deleteCar(long carId);

    Car updateCar(long carId, Car newCar);

    Detail updateDetailOnCar(long carId, String detailNumber, Detail newDetail);

}
