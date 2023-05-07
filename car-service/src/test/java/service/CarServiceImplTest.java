package service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ric.masters.carservice.entiry.Car;
import ric.masters.carservice.entiry.Detail;
import ric.masters.carservice.repository.CarRepository;
import ric.masters.carservice.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class CarServiceImplTest {
    @Mock
    private CarRepository carRepository;
    @InjectMocks
    private CarServiceImpl carService;


    @Test
    public void testGetAllCars() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car());
        cars.add(new Car());
        cars.add(new Car());
        when(carRepository.findAll()).thenReturn(cars);

    }

    @Test
    public void testGetCarById() {
        Car car = new Car(1, "2", "3");
        when(carRepository.getCarById(1L)).thenReturn(Optional.of(car));
        carRepository.save(car);
        Car result = carService.getCarByCarId(1L);
        assertEquals(result.getVinCode(), "2");
    }

    @Test
    public void testGetCarByVinCode() {
        Car car = new Car(1, "2", "3");
        when(carRepository.getCarByVinCode("2")).thenReturn(Optional.of(car));
        carRepository.save(car);
        Car result = carService.getCarByVinCode("2");
        assertEquals(result.getId(), 1);
    }

    @Test
    public void testGetCarByStateNumber() {
        Car car = new Car(1, "2", "3");
        when(carRepository.getCarByStateNumber("3")).thenReturn(Optional.of(car));
        carRepository.save(car);
        Car result = carService.getCarByStateNumber("3");
        assertEquals(result.getId(), 1);
    }

    @Test
    public void testSaveCar() {
        Car car = new Car(1, "2", "3");
        when(carRepository.save(car)).thenReturn(car);
        Car result = carService.createCar(car);
        assertEquals(result.getId(), 1L);
    }

    @Test
    public void testDeleteCar() {
        Car car = new Car(1, "2", "3");
        when(carRepository.getCarById(1L)).thenReturn(Optional.of(car));
        Car result = carService.deleteCar(1L);
        assertEquals(result.getId(),1L);
    }

    @Test
    public void testUpdateCar() {
        Car car = new Car(1, "2", "3");
        when(carRepository.getCarById(1L)).thenReturn(Optional.of(car));
        Car newCar = new Car(33, "333", "22");
        Car result = carService.updateCar(1,newCar);
        assertEquals(result.getStateNumber(),"22");
    }

    @Test
    public void testUpdateDetailOnCar() {
        Car car = new Car(1, "2", "3");
        car.setDetails(Set.of(new Detail(1,"1")));
        when(carRepository.getCarById(1L)).thenReturn(Optional.of(car));
        Detail detail = new Detail(435,"5");
        Detail result = carService.updateDetailOnCar(1,"1",detail);
        assertEquals(result.getDetailNumber(),"5");
    }
}
