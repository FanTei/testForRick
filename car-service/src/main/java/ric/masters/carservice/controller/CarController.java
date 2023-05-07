package ric.masters.carservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ric.masters.carservice.entiry.Car;
import ric.masters.carservice.entiry.Detail;
import ric.masters.carservice.service.CarService;

import java.util.List;
@RestController
@RequestMapping(value = "/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<?> getCarList() {
        try {
            List<Car> car = carService.getAllCars();
            return new ResponseEntity<>(car, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    @GetMapping(value = "id/{carId}")
    public ResponseEntity<?> getCarByCarId(@PathVariable long carId) {
        try {
            return new ResponseEntity<>(carService.getCarByCarId(carId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "vin/{vinCode}")
    public ResponseEntity<?> getCarByVinCode(@PathVariable String vinCode) {
        try {
            return new ResponseEntity<>(carService.getCarByVinCode(vinCode), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(value = "state/{stateNumber}")
    public ResponseEntity<?> getCarByStateNumber(@PathVariable String stateNumber) {
        try {
            return new ResponseEntity<>(carService.getCarByStateNumber(stateNumber), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable long id) {
        try {
            Car deletedCar = carService.deleteCar(id);
            return new ResponseEntity<>(deletedCar, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.createCar(car), HttpStatus.CREATED);
    }


    @PutMapping("/{carId}")
    public ResponseEntity<?> updateCar(@PathVariable long carId, @RequestBody Car car) {
        try {
            return new ResponseEntity<>(carService.updateCar(carId, car), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{carId}/{detailNumber}")
    public ResponseEntity<?> updateDetailOnCar(@PathVariable long carId, String detailNumber, @RequestBody Detail newDetail) {
        try {
            return new ResponseEntity<>(carService.updateDetailOnCar(carId, detailNumber, newDetail), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
