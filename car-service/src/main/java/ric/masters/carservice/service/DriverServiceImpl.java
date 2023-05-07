package ric.masters.carservice.service;

import lombok.Setter;
import org.springframework.stereotype.Service;
import ric.masters.carservice.entiry.Car;
import ric.masters.carservice.entiry.Driver;
import ric.masters.carservice.repository.DriverRepository;

import java.util.Date;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    private final DriverRepository driverRepository;
    private final CarService carService;

    public DriverServiceImpl(DriverRepository driverRepository, CarService carService) {
        this.driverRepository = driverRepository;
        this.carService = carService;
    }

    @Override
    public List<Driver> getAllDrivers() {
        List<Driver> drivers = driverRepository.findAll();
        if (drivers.size() == 0) throw new RuntimeException();
        return drivers;
    }

    @Override
    public Driver getDriverById(long driverId) {
        return driverRepository.getDriverById(driverId).orElseThrow();
    }

    @Override
    public List<Driver> getDriversByBirthday(Date birthday) {
        List<Driver> drivers = driverRepository.getDriverByBirthday(birthday);
        if (drivers.size() == 0) throw new RuntimeException();
        return drivers;
    }

    @Override
    public Driver createDriver(Driver driver) {
        return driverRepository.save(driver);
    }


    @Override
    public Driver deleteDriver(long driverId) {
        Driver deleteDriver = driverRepository.getDriverById(driverId).orElseThrow();
        driverRepository.delete(deleteDriver);
        return deleteDriver;
    }

    @Override
    public Driver updateDriver(long driverId, Driver newDriver) {
        Driver updateDriver = driverRepository.getDriverById(driverId).orElseThrow();
        updateDriver.setName(newDriver.getName());
        updateDriver.setSurname(newDriver.getSurname());
        updateDriver.setLastname(newDriver.getLastname());
        updateDriver.setPassport(newDriver.getPassport());
        updateDriver.setDriverLicense(newDriver.getDriverLicense());
        updateDriver.setBirthday(newDriver.getBirthday());
        driverRepository.save(newDriver);
        return newDriver;
    }

    @Override
    public Driver addCarToDriver(long driverId, long carId) {
        Driver driver = driverRepository.getDriverById(driverId).orElseThrow();
        Car car = carService.getCarByCarId(carId);
        driver.getCars().add(car);
        driverRepository.save(driver);
        return driver;
    }
}
