package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public abstract List<User> getAllUsers();
    public abstract User saveUser(User User);
    public abstract User getUserById(Integer UserId);
    public abstract void deleteUserById(Integer UserId);
    public abstract List<User> searchUsers(String searchString);






}
