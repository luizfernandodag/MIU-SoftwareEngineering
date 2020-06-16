package edu.miu.cs.cs425.project.miucarrental.repository;

import edu.miu.cs.cs425.project.miucarrental.model.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarStatusRepository extends JpaRepository<CarStatus, Long> {
}

