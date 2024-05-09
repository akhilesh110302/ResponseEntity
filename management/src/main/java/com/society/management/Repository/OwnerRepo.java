package com.society.management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.society.management.entity.OwnerEntity;

public interface OwnerRepo extends JpaRepository<OwnerEntity, Integer> {

}
