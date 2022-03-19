package com.example.exercise9.repository;

import com.example.exercise9.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {

    @Query(value = "SELECT d FROM Deposit d WHERE d.customerId = ?1")
    List<Deposit> findAllByCustomerId(Long customerId);
}
