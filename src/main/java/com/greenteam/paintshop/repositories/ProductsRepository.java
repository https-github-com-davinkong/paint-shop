package com.greenteam.paintshop.repositories;

import com.greenteam.paintshop.entities.Jobs;
import com.greenteam.paintshop.entities.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {
    List<Products> findAllByJobsEquals(Jobs jobs);
}
