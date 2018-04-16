package ua.springboot.web.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "car_class")
@Getter
@Setter
@NoArgsConstructor
public class CarClass extends BaseEntity{

	@Column(name = "car_class")
	private String carClass;
	
	@OneToMany(mappedBy = "fuel", cascade = {DETACH, MERGE, PERSIST,REFRESH},
			fetch = FetchType.LAZY)
	private List<Car> cars;
	
}
