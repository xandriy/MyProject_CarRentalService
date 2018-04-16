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
@Table(name = "history")
@Getter
@Setter
@NoArgsConstructor
public class History extends BaseEntity{

	private String dayFrom;
	
	private String dayTo;
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/*,
			fetch = FetchType.LAZY*/)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@ManyToOne(cascade = CascadeType.ALL/*,
			fetch = FetchType.LAZY*/)
	@JoinColumn(name = "user_id", nullable = true)
	private UserEntity user;
	
	
}
