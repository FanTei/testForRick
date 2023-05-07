package ric.masters.carservice.service;

import ric.masters.carservice.entiry.Driver;

import java.util.Date;
import java.util.List;

public interface DriverService {


    List<Driver> getAllDrivers();

    Driver getDriverById(long driverId);

    List<Driver> getDriversByBirthday(Date birthday);

    Driver createDriver(Driver driver);


    Driver deleteDriver(long driverId);

    Driver updateDriver(long driverId, Driver driver);

    Driver addCarToDriver(long driverId, long carId);
}
