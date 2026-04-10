package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Specification;

@Repository
public interface SpecificationRepository extends JpaRepository<Specification, Long> {

}
