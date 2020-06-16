package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    public List<Car> findByCarStatusIs(CarStatus carStatus);
    public Optional<Car> findByPlateNumber(String plateNumber);
    Page<Car> findAllByCarMakeContainingOrCarBrandContainingOrModelContaining(String make,
                                                                              String brand,
                                                                              String model,
                                                                              Pageable pageable);

    Page<Car> findAllByDistanceAndStatusAndTypeAndPaymentOption(DistanceMile distance,
                                                                CarStatusEnum status,
                                                                CarType type,
                                                                PaymentOption payment,
                                                                Pageable pageable);

}