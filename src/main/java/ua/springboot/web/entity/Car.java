package ua.springboot.web.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
public class Car extends BaseEntity{
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/*,
			fetch = FetchType.LAZY*/)
	@JoinColumn(name = "car_class_id")
	private CarClass carClass;
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			fetch = FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private CarModel model;
	
	@Column(name = "manufacture_year")
	private int manufactureYear;
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/*,
			fetch = FetchType.LAZY*/)
	@JoinColumn(name = "fuel_id")
	private Fuel fuel;
	
	@Column(name = "power")
	private int power;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/*,
			fetch = FetchType.LAZY*/)
	@JoinColumn(name = "transmission_id")
	private Transmission transmission;
	
	@OneToMany(mappedBy = "car", cascade = {DETACH, MERGE, PERSIST,REFRESH},
			fetch = FetchType.LAZY)
	private List<History> histories;
	
	
	
	@Column(name = "number_of_place")
	private int numberOfPlace;

	@Column(name = "day_rental")
	private int dayRent;
	
	@Column(name = "week_rental")
	private int weekRent;
	
	@Column(name = "monthRental")
	private int monthRent;

	@Column(name = "is_rented")
	private boolean isRented;
	
	@Column(name = "is_booked")
	private boolean isBooked;
	
	@Column(name = "photoPath")
	private String[] photoPath;

}
