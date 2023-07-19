package com.irrigation.irrigation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irrigation.irrigation.dto.PlotDTO;
import com.irrigation.irrigation.entity.PlotEntity;
import com.irrigation.irrigation.repository.PlotRepository;


@Service
public class PlotService {

	@Autowired
	private PlotRepository plotrepository;
	
	public List<PlotEntity> findAllPlots(){
		List<PlotEntity> plots = plotrepository.findAll();
		return plots;
	}
	
	public void addPlot(PlotEntity plotentity) {
		plotrepository.save(plotentity);
	}
	
	public void updatePlot(PlotDTO plotdto) {
		PlotEntity plot = plotrepository.findByName(plotdto.getName());
		plot.setArea(plotdto.getArea());
		plot.setCrop(plotdto.getCrop());
		plot.setWaterQuantity(plotdto.getWaterQuantity());
		plot.setID(plot.getID());
		plotrepository.save(plot);
	}
	
	public void deleteplot(PlotDTO plotdto) {
		PlotEntity plot = plotrepository.findByName(plotdto.getName());
		plotrepository.delete(plot);
		// TODO Auto-generated method stub

	}
}
