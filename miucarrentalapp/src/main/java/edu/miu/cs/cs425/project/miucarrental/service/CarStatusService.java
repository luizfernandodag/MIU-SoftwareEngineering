package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CarStatusService {
    public CarStatus save(CarStatus carStatus);
    public List<CarStatus> findAll();
    public CarStatus findById(Long id);
    public void deleteById(Long id);
}
