package edu.miu.cs.cs425.project.miucarrental.service.impl;

import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import edu.miu.cs.cs425.project.miucarrental.repository.CarStatusRepository;
import edu.miu.cs.cs425.project.miucarrental.service.CarStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarStatusServiceImpl implements CarStatusService {

    @Autowired
    private CarStatusRepository carStatusRepository;

    @Override
    public CarStatus save(CarStatus carStatus) {
        return carStatusRepository.save(carStatus);
    }

    @Override
    public List<CarStatus> findAll() {
        return (List<CarStatus>)carStatusRepository.findAll();
    }

    @Override
    public CarStatus findById(Long id) {
        return carStatusRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        carStatusRepository.deleteById(id);
    }
}
