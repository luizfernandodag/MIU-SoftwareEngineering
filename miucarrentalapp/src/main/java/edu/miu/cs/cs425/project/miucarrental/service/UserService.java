package edu.miu.cs.cs425.project.miucarrental.service;

import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public abstract List<User> getAllUsers();
    public abstract User saveUser(User User);
    public abstract User getUserById(Integer UserId);
    public abstract void deleteUserById(Integer UserId);
    public abstract Page<User> searchUsers(String searchString, int pageNo);






}
