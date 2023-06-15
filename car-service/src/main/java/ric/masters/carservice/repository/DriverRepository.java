package ric.masters.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ric.masters.carservice.entity.Driver;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Optional<Driver> getDriverById(Long id);

    List<Driver> getDriverByBirthday(Calendar birthday);
}
