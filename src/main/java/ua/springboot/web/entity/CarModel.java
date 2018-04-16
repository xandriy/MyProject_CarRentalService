package ua.springboot.web.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "car_model")
@Getter
@Setter
@NoArgsConstructor
public class CarModel extends BaseEntity{
	
	private String model;
	
	@ManyToOne(/*cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},*/
			fetch = FetchType.EAGER)
	@JoinColumn(name = "make_id")
	private CarMake make;
	
	@OneToMany(mappedBy = "model",/* cascade = {DETACH, MERGE, PERSIST,REFRESH},*/
			fetch = FetchType.LAZY)
	private List<Car> cars;
	
}
