package com.irrigation.irrigation.dto;

import java.time.*;

import com.irrigation.irrigation.entity.PlotEntity;

import lombok.Data;

@Data
public class SensorDTO {

	private LocalTime startTime;
	private LocalTime endTime;
	private Boolean running;
	private Boolean isCompleted;
	private String name;
	
}
