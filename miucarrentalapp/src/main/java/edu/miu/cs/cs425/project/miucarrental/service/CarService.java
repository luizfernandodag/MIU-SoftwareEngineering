package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    public Car save(Car car);
    public List<Car> findAll();
    public void deleteById(Long id);
    public Car findById(Long id);
}
