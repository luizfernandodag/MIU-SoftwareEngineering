package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;

import java.util.List;

public interface CarStatusService {
    public CarStatus save(CarStatus carStatus);
    public List<CarStatus> findAll();
    public CarStatus findById(Long id);
    public void deleteById(Long id);
}
