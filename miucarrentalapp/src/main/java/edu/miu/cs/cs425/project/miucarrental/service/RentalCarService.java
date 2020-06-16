package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.RentalCar;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RentalCarService {
    public RentalCar save(RentalCar rentalCar);
    public List<RentalCar> findAll();
    public void deleteById(Integer id);
    public RentalCar findById(Integer id);
    public abstract List<RentalCar> searchRentalCars(String searchString);

}


