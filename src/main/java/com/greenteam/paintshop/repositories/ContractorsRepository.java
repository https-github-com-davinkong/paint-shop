package com.greenteam.paintshop.repositories;

import com.greenteam.paintshop.entities.Contractors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ContractorsRepository extends JpaRepository<Contractors, Long> {

    Optional<Contractors> findByEmail(String email);

}
