package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.*;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    public Car save(Car car);
    public List<Car> findAll();
    public void deleteById(Long id);
    public Car findById(Long id);
    public Page<Car> searchDataPaged(String searchString, int pageNo);
    public Page<Car> filterDataPaged(DistanceMile distance,
                                     CarStatusEnum status,
                                     CarType type,
                                     PaymentOption payment, int pageNo);
}
