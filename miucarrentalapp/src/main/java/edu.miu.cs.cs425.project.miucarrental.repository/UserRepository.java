package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //NOT STRING PARAMETERS SEARCH
    List<User> findAllByDriversLicenseContaining(String driverLicense);
   // List<User> findAllByDobEquals(LocalDate dateOfBirth);
    List<User> findAllByRolesEquals(Role role);

    //STRING PARAMETERS
    List<User> findAllByFirstNameContainingOrLastNameContaining(String firstName, String lastName);




}