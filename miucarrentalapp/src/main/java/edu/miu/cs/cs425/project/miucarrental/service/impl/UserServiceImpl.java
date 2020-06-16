package edu.miu.cs.cs425.project.miucarrental.service.impl;

import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import edu.miu.cs.cs425.project.miucarrental.repository.UserRepository;
import edu.miu.cs.cs425.project.miucarrental.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    @Override
    public User saveUser(User User) {
        return repository.save(User);

    }

    @Override
    public User getUserById(Integer UserId) {
        return repository.findById(UserId).orElse(null);
    }

    @Override
    public void deleteUserById(Integer UserId) {
        repository.deleteById(UserId);

    }

    @Override
    public List<User> searchUsers(String searchString) {
        if (searchString.contains("-")) {
            return repository.findAllByDriversLicenseContaining(searchString);

        }
        //else if (isDate(searchString)) {
        //      return repository.findAllByDobEquals(LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE));
        //  }
        else {
            return repository.findAllByFirstNameContainingOrLastNameContaining(searchString, searchString);


        }
    }


    private static boolean isDate(String searchString) {
        boolean dateBool = false;
        try {
            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
            dateBool = true;
        } catch (Exception ex) {
            if (ex instanceof DateTimeParseException) {
                dateBool = false;
            }
        }
        return dateBool;
    }

    private static boolean containsDecimalPoint(String searchString) {
        return searchString.contains(".");
    }

    private static boolean zipUS(String searchString) {
        return searchString.matches("\\d{5}");
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
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


        