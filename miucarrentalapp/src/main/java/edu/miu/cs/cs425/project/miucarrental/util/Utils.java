package edu.miu.cs.cs425.project.miucarrental.util;

import edu.miu.cs.cs425.project.miucarrental.model.Car;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

public class Utils {
    public static Car selectedCar = null;

    public static User getSelectedUser(List<User> users){
        if(users.size() > 0){
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            System.out.println(auth.getName());
            User user = users.stream().filter( n -> n.getUsername().equals(auth.getName()))
                    .findFirst().orElse(null);
           return user;
        }
        return null;
    }

    public static Car getSelectedCar(){
        return selectedCar;
    }
}
