package ua.springboot.web.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "car_make")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CarMake extends BaseEntity{
	
	private String make;
	
	@OneToMany(mappedBy = "make", cascade = {DETACH, MERGE, PERSIST,REFRESH},
			fetch = FetchType.LAZY)
	private List<CarModel> models;
	
	
}
