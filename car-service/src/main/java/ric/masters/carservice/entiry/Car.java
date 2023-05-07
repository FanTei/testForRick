package ric.masters.carservice.entiry;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "car")
public class Car {


    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    @Column(name = "vin_code")
    private String vinCode;

    @NotNull
    @Column(name = "state_number")
    private String stateNumber;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "car_id")
    private Set<Detail> details;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "year_to_prod")
    private String yearToProd;

    public Car(long id, String vinCode, String stateNumber) {
        this.id = id;
        this.vinCode = vinCode;
        this.stateNumber = stateNumber;
        this.details = new HashSet<>();
    }
}
