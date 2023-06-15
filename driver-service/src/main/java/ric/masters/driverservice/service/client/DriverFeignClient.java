package ric.masters.driverservice.service.client;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ric.masters.driverservice.entity.DtoDriver;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@FeignClient(name = "car-service", url = "http://localhost:9090/driver")
public interface DriverFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "id/{driverId}",
            consumes = "application/json"
    )
    DtoDriver getDriver(@PathVariable long driverId);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "birthDay/{birthDay}",
            consumes = "application/json"
    )
    List<DtoDriver> getAllDriversByDate(@PathVariable String birthDay);
}
