package ric.masters.carservice.service;

import org.springframework.stereotype.Service;
import ric.masters.carservice.entity.Car;
import ric.masters.carservice.entity.Detail;
import ric.masters.carservice.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        List<Car> allCars = carRepository.findAll();
        if (allCars.size() == 0) throw new RuntimeException();
        return allCars;
    }

    @Override
    public Car getCarByCarId(long carId) {
        return carRepository.getCarById(carId).orElseThrow();
    }

    @Override
    public Car getCarByVinCode(String vinCode) {
        return carRepository.getCarByVinCode(vinCode).orElseThrow();
    }

    @Override
    public Car getCarByStateNumber(String stateNumber) {
        return carRepository.getCarByStateNumber(stateNumber).orElseThrow();
    }

    @Override
    public Car createCar(Car createdCar) {

        return carRepository.save(createdCar);
    }

    @Override
    public Car deleteCar(long carId) {
        Car deletedCar = carRepository.getCarById(carId).orElseThrow();
        carRepository.delete(deletedCar);
        return deletedCar;
    }

    @Override
    public Car updateCar(long carId, Car newCar) {
        Car updatedCar = carRepository.getCarById(carId).orElseThrow();
        updatedCar.setVinCode(newCar.getVinCode());
        updatedCar.setStateNumber(newCar.getStateNumber());
        updatedCar.setBrand(newCar.getBrand());
        updatedCar.setModel(newCar.getModel());
        updatedCar.setYearToProd(newCar.getYearToProd());
        carRepository.save(updatedCar);
        return updatedCar;
    }

    @Override
    public Detail updateDetailOnCar(long carId, String detailNumber, Detail newDetail) {
        if (detailNumber == null || detailNumber.isEmpty() && !detailNumber.chars().allMatch(c -> Character.isDigit(c) || Character.isAlphabetic(c)))
            throw new RuntimeException();
        Car updatedCar = carRepository.getCarById(carId).orElseThrow();
        for (Detail detail : updatedCar.getDetails()) {
            if (detail.getDetailNumber().equals(detailNumber)) {
                detail = newDetail;
                carRepository.save(updatedCar);
                return detail;
            }
        }
        throw new RuntimeException();
    }
}
