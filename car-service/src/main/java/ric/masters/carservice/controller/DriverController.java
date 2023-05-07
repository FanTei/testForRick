package ric.masters.carservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ric.masters.carservice.entiry.Driver;
import ric.masters.carservice.service.DriverService;

import java.util.Date;

@RestController
@RequestMapping("/driver")
public class DriverController {
    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    public ResponseEntity<?> getAllDrivers() {
        try {
            return new ResponseEntity<>(driverService.getAllDrivers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("birthDay/{birthDay}")
    public ResponseEntity<?> getDriversByBirthday(@PathVariable Date birthDay) {
        try {
            return new ResponseEntity<>(driverService.getDriversByBirthday(birthDay), HttpStatus.OK);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("id/{id}")
    public Driver getDriverById(@PathVariable long id) {
        return driverService.getDriverById(id);
    }

    @PostMapping
    public ResponseEntity<?> createDriver(@RequestBody Driver driver) {
        return new ResponseEntity<>(driverService.createDriver(driver), HttpStatus.OK);
    }

    @DeleteMapping("/{driverId}")
    public ResponseEntity<?> deleteDriver(@PathVariable long driverId) {
        try {
            return new ResponseEntity<>(driverService.deleteDriver(driverId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{driverId}")
    public ResponseEntity<?> updateDriver(@PathVariable long driverId, @RequestBody Driver newDriver) {
        try {
            return new ResponseEntity<>(driverService.updateDriver(driverId, newDriver), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PutMapping("/{driverId}/{carId}")
    public ResponseEntity<?> addCarToDriver(@PathVariable long driverId, @PathVariable long carId) {
        try {
            return new ResponseEntity<>(driverService.addCarToDriver(driverId, carId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
