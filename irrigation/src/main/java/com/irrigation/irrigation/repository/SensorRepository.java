package com.irrigation.irrigation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.irrigation.entity.SensorEntity;


@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Integer> {
		public SensorEntity findByName(String name);
}
