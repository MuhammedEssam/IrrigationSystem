package com.irrigation.irrigation.dto;

import lombok.Data;

@Data
public class PlotDTO {
	
	private String Name;
	private double Area;
	private String Crop;
	private double WaterQuantity;
}
