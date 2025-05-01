package com.example.pos.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.pos.infrastructure.entity.SaleEntity;

public interface SaleRepositoryJpa extends JpaRepository<SaleEntity, Integer>, JpaSpecificationExecutor<SaleEntity> {

}
