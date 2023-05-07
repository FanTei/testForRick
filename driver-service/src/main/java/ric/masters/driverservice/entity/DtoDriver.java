package ric.masters.driverservice.entity;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DtoDriver {

    private long id;

    private String name;


    private String surname;


    private String lastname;


    private String passport;


    private String driverLicense;


    private Date birthday;
}
