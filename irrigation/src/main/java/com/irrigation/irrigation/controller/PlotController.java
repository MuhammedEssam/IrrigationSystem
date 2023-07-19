package com.irrigation.irrigation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irrigation.irrigation.dto.PlotDTO;
import com.irrigation.irrigation.entity.PlotEntity;
import com.irrigation.irrigation.services.PlotService;

@RestController
public class PlotController {


	
	@Autowired
	private PlotService plotservice;
	
	@GetMapping("/Plots")
	public List<PlotEntity> getPlots(){
		List<PlotEntity> plots = plotservice.findAllPlots();
		return plots;
	}
	
	@PostMapping("/addPlot")
	public ResponseEntity addPlot(@RequestBody PlotEntity plotentity) {
	plotservice.addPlot(plotentity);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/updatePlot")
	public ResponseEntity updatePlot(@RequestBody PlotDTO plotdto) {
		plotservice.updatePlot(plotdto);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@PostMapping("/deletePlot")
	public ResponseEntity deletePlot(@RequestBody PlotDTO plotdto) {
		plotservice.deleteplot(plotdto);
		return new ResponseEntity(HttpStatus.OK);
	}
}
