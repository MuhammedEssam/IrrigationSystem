package com.irrigation.irrigation.entity;

import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "sensors")
public class SensorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@Column(name= "Name")
	private String name ; 
	
	@Column(name="isCompleted")
	private Boolean isCompleted;
	
	@Column(name="Running")
	private Boolean running;
	
	@Column(name="StartTime")
	private LocalTime startTime;
	
	@Column(name="EndTime")
	private LocalTime endTime;
	
	@ManyToOne
	@JoinColumn(name="plot_id")
	private PlotEntity plots;
}
