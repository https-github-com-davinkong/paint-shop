package com.greenteam.paintshop.repositories;

import com.greenteam.paintshop.entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients, Long> {



}
