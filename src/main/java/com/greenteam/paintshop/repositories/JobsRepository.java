package com.greenteam.paintshop.repositories;

import com.greenteam.paintshop.entities.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, Long> {

}
