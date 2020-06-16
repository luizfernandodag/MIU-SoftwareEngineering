package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.Role;
import edu.miu.cs.cs425.project.miucarrental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;



@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByNameContaining(String name);

}