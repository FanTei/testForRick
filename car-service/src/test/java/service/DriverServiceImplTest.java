package service;

import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ric.masters.carservice.entiry.Car;
import ric.masters.carservice.entiry.Driver;
import ric.masters.carservice.repository.CarRepository;
import ric.masters.carservice.repository.DriverRepository;
import ric.masters.carservice.service.CarServiceImpl;
import ric.masters.carservice.service.DriverServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class DriverServiceImplTest {
    @Mock
    private DriverRepository driverRepository;
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private DriverServiceImpl driverService;

    @Test
    public void testGetAllDrivers() {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver());
        drivers.add(new Driver());
        when(driverRepository.findAll()).thenReturn(drivers);
    }

    @Test
    public void testGeDriverById() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setName("ddd");
        when(driverRepository.getDriverById(1L)).thenReturn(Optional.of(driver));
        Driver result = driverService.getDriverById(1L);
        assertEquals(result.getName(), "ddd");
    }

    @Test
    public void testCreateDriver() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setName("ddd");
        when(driverRepository.save(driver)).thenReturn(driver);
        Driver result = driverService.getDriverById(1L);
        assertEquals(result.getName(), "ddd");
    }

    @Test
    public void testUpdateDriver() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setName("ddd");
        when(driverRepository.getDriverById(1L)).thenReturn(Optional.of(driver));
        Driver newDriver = new Driver();
        newDriver.setName("bbb");
        Driver result = driverService.updateDriver(1L, newDriver);
        assertEquals(result.getName(), "bbb");
    }

    @Test
    public void testAddCarToDriver() {
        Driver driver = new Driver();
        driver.setId(1L);
        driver.setCars(new ArrayList<>());
        Car car = new Car(1, "1", "1");
        carRepository.save(car);
        driverRepository.save(driver);
        when(carRepository.save(car)).thenReturn(car);
        when(driverRepository.save(driver)).thenReturn(driver);
    }
}
