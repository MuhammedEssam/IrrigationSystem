package com.irrigation.irrigation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.irrigation.entity.SensorEntity;
import com.irrigation.irrigation.services.irrigateService;
import com.irrigation.irrigation.services.sensorService;

@RestController
public class sensorController {
	
	@Autowired
	private sensorService sensorservice;
	
	@Autowired
	private irrigateService irrigateservice;
	
	@PostMapping("/addSensor")
	public void addSensor(@RequestBody SensorEntity sensorentity) {
		sensorservice.addSensor(sensorentity);
	}
	
	@PostMapping("/sensorToPlot")
	public ResponseEntity sensorToPlot(@RequestParam String plotName , @RequestParam String sensorName) {
		irrigateservice.sensorToPlot(plotName, sensorName);
		return new ResponseEntity(HttpStatus.OK);
	}
}
