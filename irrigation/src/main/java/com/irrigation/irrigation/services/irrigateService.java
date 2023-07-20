package com.irrigation.irrigation.services;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.irrigation.irrigation.dto.SensorDTO;
import com.irrigation.irrigation.entity.PlotEntity;
import com.irrigation.irrigation.entity.SensorEntity;
import com.irrigation.irrigation.repository.PlotRepository;
import com.irrigation.irrigation.repository.SensorRepository;

/**
 * @author Mohamed Essam
 *
 */
@Service
public class irrigateService {

	@Autowired
	private sensorService sensorservice;

	@Autowired
	private PlotRepository plotrepository;

	@Autowired
	private SensorRepository sensorrepository;

	@Scheduled(fixedDelay = 60000)
	public void irrigate() {
		List<SensorEntity> sensors = sensorservice.findAllSensors();
		for (int i = 0; i < sensors.size(); i++) {
			if (sensors.get(i).getStartTime().withSecond(0).withNano(0).equals(LocalTime.now().plusHours(1).withSecond(0).withNano(0))
					&& sensors.get(i).getRunning() == false) {
				System.out.println("Sensor:  " + sensors.get(i).getName() + "  is running");
				sensors.get(i).setRunning(true);
				irrigateIsRunning(sensors.get(i));
			} else if (sensors.get(i).getEndTime().withSecond(0).withNano(0).isBefore(LocalTime.now().plusHours(1).withSecond(0).withNano(0))) {
				System.out.println("Sensor:  " + sensors.get(i).getName() + "  is completed");
				sensors.get(i).setIsCompleted(true);
			}
			sensorservice.updateSensor(sensors.get(i));
		}
	}

	private void irrigateIsRunning(SensorEntity sensor) {
		System.out.println("Irrigating plot: " + sensor.getPlots().getName());
	}

	public void sensorToPlot(String plotName, String sensorName) {
		PlotEntity plot = plotrepository.findByName(plotName);
		SensorEntity sensor = sensorrepository.findByName(sensorName);
		sensor.setPlots(plot);
		sensorrepository.save(sensor);
	}
	
	@Scheduled(fixedRate = 24 * 60 * 60 * 1000)
	public void resetSensors() {
		System.out.println(" Reset sensor every day ");
		List<SensorEntity> sensors = sensorservice.findAllSensors();
		for (int i = 0; i < sensors.size(); i++) {
			sensors.get(i).setIsCompleted(false);
			sensorservice.updateSensor(sensors.get(i));
	}
}
}
