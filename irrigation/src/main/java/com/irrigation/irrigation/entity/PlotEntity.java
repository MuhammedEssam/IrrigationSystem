package com.irrigation.irrigation.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "plots")
public class PlotEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer ID;
	
	@Column(name="Name" , unique = true)
	private String name;
	
	@Column(name="Area")
	private double area;
	
	@Column(name="Crop")
	private String crop;
	
	@Column(name="WaterQuantity")
	private double waterQuantity;
	

}
