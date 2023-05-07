package ric.masters.carservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ric.masters.carservice.entiry.Car;

import java.util.Optional;
import java.util.OptionalInt;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> getCarById(Long carId);

    Optional<Car> getCarByVinCode(String vinCode);

    Optional<Car> getCarByStateNumber(String stateNumber);
}
