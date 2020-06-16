package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public List<Car> findByCarStatusIs(CarStatus carStatus);
    public Optional<Car> findByPlateNumber(String plateNumber);
}