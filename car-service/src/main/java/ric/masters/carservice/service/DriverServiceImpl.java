package ric.masters.carservice.service;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.stereotype.Service;
import ric.masters.carservice.entity.Car;
import ric.masters.carservice.entity.Driver;
import ric.masters.carservice.repository.DriverRepository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    public List<Driver> getDriversByBirthday(String birthday) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(birthday);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        List<Driver> drivers = driverRepository.getDriverByBirthday(calendar);
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
        driverRepository.save(updateDriver);
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
