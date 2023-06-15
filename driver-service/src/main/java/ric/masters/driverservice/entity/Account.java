package ric.masters.driverservice.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "account")
public class Account {
    @Id
    private long id;

    @Column(name = "count")
    private double countInRed;

    @Column(name = "driver_id")
    private long driverId;

    public Account(double countInRed, long driverId) {
        this.countInRed = countInRed;
        this.driverId = driverId;
    }
}
