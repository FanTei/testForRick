package ric.masters.carservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "surname",nullable = false)
    private String surname;

    @Column(name = "lastname",nullable = false)
    private String lastname;

    @Column(name = "pasport",nullable = false)
    private String passport;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column(name = "birthday",nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar birthday;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "driver_id")
    List<Car> cars;
}

