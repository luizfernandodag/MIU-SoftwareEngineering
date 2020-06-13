package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.Car;

import java.util.List;

public interface CarService {
    public Car save(Car car);
    public List<Car> findAll();
    public void deleteById(Long id);
    public Car findById(Long id);
}
