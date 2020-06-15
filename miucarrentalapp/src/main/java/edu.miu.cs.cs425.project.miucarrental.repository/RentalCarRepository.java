package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.RentalCar;
import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface  RentalCarRepository extends JpaRepository<RentalCar, Integer> {


    List<RentalCar> findAllByUserEquals(User user);
    List<RentalCar> findAllByCarEquals(Car car);

//FIND BY DATES
    //Find all car pickups BETWEEN two dates

    List<RentalCar> findAllByPickupDateAfterOrPickupDateBeforeOrPickupDateEqualsOrReturnDateAfterOrReturnDateBeforeOrReturnDateEquals(LocalDate PickupDateBefore,
                                                                                                                                       LocalDate PickupDateAfter,
                                                                                                                                       LocalDate PickupDateEquals,
                                                                                                                                       LocalDate ReturnDateBefore,
                                                                                                                                       LocalDate ReturnDateAfter,
                                                                                                                                       LocalDate ReturnDateEquals);
    List<RentalCar> findAllByPickupDateBetween(LocalDate date1, LocalDate date2);
    //Find all car PICKUPS AFTER certain date
    List<RentalCar> findAllByPickupDateAfter(LocalDate date );
    //Find all car PICKUPS BEFORE certain date
    List<RentalCar> findAllByPickupDateBefore(LocalDate date );
    //Find All car PICKUPS in a certain date ( by day comparison)
    List<RentalCar> findAllByPickupDateEquals(LocalDate date );

    //Find all car RETURNS AFTER certain date
    List<RentalCar> findAllByReturnDateAfter(LocalDate date );

    //Find all car RETURNS BEFORE certain date
    List<RentalCar> findAllByReturnDateBefore(LocalDate date );

    //Find All car RETURNS in a certain date ( by day comparison)
    List<RentalCar> findAllByReturnDateEquals(LocalDate date );

//FIND BY USER
    //NAME AND DRIVER LICENSEcontain
List<RentalCar> findAllByUser_FirstNameContainingOrUser_LastNameContaining(
        String firstName,
        String lastName);






}

