package ric.masters.carservice.service;

import ric.masters.carservice.entity.Driver;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface DriverService {


    List<Driver> getAllDrivers();

    Driver getDriverById(long driverId);

    List<Driver> getDriversByBirthday(String birthday) throws ParseException;

    Driver createDriver(Driver driver);


    Driver deleteDriver(long driverId);

    Driver updateDriver(long driverId, Driver driver);

    Driver addCarToDriver(long driverId, long carId);
}
