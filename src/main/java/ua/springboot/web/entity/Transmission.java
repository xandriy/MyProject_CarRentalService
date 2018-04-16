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

@Entity
@Table(name = "transmission")
@Getter
@Setter
@NoArgsConstructor
public class Transmission extends BaseEntity{

	private String transmission;
	
	@OneToMany(mappedBy = "transmission", cascade = {DETACH, MERGE, PERSIST,REFRESH},
			fetch = FetchType.LAZY)
	private List<Car> cars;
}
