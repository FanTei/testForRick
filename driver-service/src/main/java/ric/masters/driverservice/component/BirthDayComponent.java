package ric.masters.driverservice.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ric.masters.driverservice.entity.DtoDriver;
import ric.masters.driverservice.service.client.DriverFeignClient;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component

public class BirthDayComponent {
    private final DriverFeignClient driverFeignClient;

    public BirthDayComponent(DriverFeignClient driverFeignClient) {
        this.driverFeignClient = driverFeignClient;
    }

    @Scheduled(fixedDelay = 86400000)
    private void happyBirthDay() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        String date = dateFormat.format(calendar.getTime());
        List<DtoDriver> driverList = driverFeignClient.getAllDriversByDate(date);
        for (DtoDriver driver : driverList) {
            System.out.println("Happy BirthDay" + driver.getName() + " " + driver.getSurname());
        }
    }
}
