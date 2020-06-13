package edu.miu.cs.cs425.project.miucarrental.repository;


import edu.miu.cs.cs425.project.miucarrental.model.Address;
import edu.miu.cs.cs425.project.miucarrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}