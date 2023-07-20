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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name= "sensors")
public class SensorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@Column(name= "NAME" , unique = true)
	private String name ; 
	
	@Column(name="STARTTIME")
	private LocalTime startTime;
	
	@Column(name="ENDTIME")
	private LocalTime endTime;
	
	@Column(name="RUNNING")
	private Boolean running;
	
	@Column(name="ISCOMPLETED")
	private Boolean isCompleted;
	
	@ManyToOne
    @JoinColumn(name = "Plot_ID")
	@JsonIgnore
	private PlotEntity plots;
}
