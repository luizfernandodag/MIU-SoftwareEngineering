package edu.miu.cs.cs425.project.miucarrental.service.impl;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.RentalCar;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.repository.RentalCarRepository;
import edu.miu.cs.cs425.project.miucarrental.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

public class RentalCarServiceImpl implements RentalCarService {
    @Autowired
    private RentalCarRepository rentalCarRepository;
    @Override
    public RentalCar save(RentalCar rentalCar) {
        return this.rentalCarRepository.save(rentalCar);
    }

    @Override
    public List<RentalCar> findAll() {
        return this.rentalCarRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.rentalCarRepository.deleteById(id);
    }

    @Override
    public RentalCar findById(Integer id) {
        return this.rentalCarRepository.findById(id).get();
    }

    @Override
    public List<RentalCar> searchRentalCars(String searchString) {
        if(isDate(searchString)) {

            LocalDate date = LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            return rentalCarRepository.findAllByPickupDateAfterOrPickupDateBeforeOrPickupDateEqualsOrReturnDateAfterOrReturnDateBeforeOrReturnDateEquals(date,
                    date,
                    date,
                    date,
                    date,
                    date);

        }
        else {

            return rentalCarRepository.findAllByUser_FirstNameContainingOrUser_LastNameContaining(
                    searchString,
                    searchString
            );
        }


    }





    private static  boolean isDate(String searchString) {
        boolean dateBool = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            dateBool = true;
        } catch(Exception ex) {
            if(ex instanceof DateTimeParseException) {
                dateBool = false;
            }
        }
        return dateBool;
    }

    private static boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

    private static boolean zipUS( String searchString ) {
        return searchString.matches( "\\d{5}" );
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

//    public static boolean isTwoDates(String dates)
//    {
//        boolean isTwoDates = false;
//
//        String[] datesStrings = dates.split(" ");
//
//        if(datesStrings.length==2)
//        {
//            if(isDate(datesStrings[0])&& isDate(datesStrings[1]))
//                isTwoDates = true;
//        }
//        return  isTwoDates;
//
//    }
}




