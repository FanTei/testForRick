package ric.masters.carservice.repository;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ric.masters.carservice.entiry.Driver;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> getDriverById(Long id);

    List<Driver> getDriverByBirthday(Date birthday);
}
