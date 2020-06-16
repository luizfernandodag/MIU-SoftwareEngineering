package edu.miu.cs.cs425.project.miucarrental;

import edu.miu.cs.cs425.project.miucarrental.model.Address;
import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.repository.AddressRepository;
import edu.miu.cs.cs425.project.miucarrental.repository.CarRepository;
import edu.miu.cs.cs425.project.miucarrental.repository.RoleRepository;
import edu.miu.cs.cs425.project.miucarrental.repository.UserRepository;
import edu.miu.cs.cs425.project.miucarrental.util.GeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import java.time.LocalDate;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
//@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class MiuCarRentalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(MiuCarRentalApplication.class, args);
    }

    //ADD SOME INITIAL DATA
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;

    private User upsertUser(User user) {
        boolean exist = userRepository.findByUsername(user.getUsername()).isPresent();
        if (exist)
            return user;
        return userRepository.save(user);
    }

    private Car upsertCar(Car car) {

        boolean exist = carRepository.findByPlateNumber(car.getPlateNumber()).isPresent();
        if (exist)
            return car;
        return carRepository.save(car);
    }

    @Override
    public void run(String... args) throws Exception {
        GeneratorUtils.generateCars().forEach(car -> {
            Car cr = this.upsertCar(car);
            System.out.println(cr);
        });

        GeneratorUtils.generateUsers().forEach(user -> {
            User usr = this.upsertUser(user);
            System.out.println(usr);
        });


    }
}
