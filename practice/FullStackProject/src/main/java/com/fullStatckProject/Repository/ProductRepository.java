package com.fullStatckProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullStatckProject.Entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
