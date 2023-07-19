package com.irrigation.irrigation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.irrigation.dto.SensorDTO;
import com.irrigation.irrigation.entity.SensorEntity;
import com.irrigation.irrigation.repository.SensorRepository;

@Service
public class sensorService {

	@Autowired
	SensorRepository sensorrepository;
	
	public List<SensorEntity> findAllSensors(){
		List<SensorEntity> sensors = sensorrepository.findAll();
		return sensors;
	}
	
	public void updateSensor(SensorEntity sensor) {
	sensorrepository.save(sensor);
	}
	
	public void addSensor(SensorEntity sensorentity) {
		sensorrepository.save(sensorentity);
	}
	
	public SensorEntity getSensor(String name) {
		SensorEntity sensor = sensorrepository.findByName(name);
		return sensor;
	}
}
