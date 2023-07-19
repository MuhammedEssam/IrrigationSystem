package com.irrigation.irrigation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.irrigation.irrigation.entity.PlotEntity;

@Repository
public interface PlotRepository extends JpaRepository<PlotEntity, Integer> {
	public PlotEntity findByName(String name);

}
