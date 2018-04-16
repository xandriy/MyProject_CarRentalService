package ua.springboot.web.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
public class Location extends BaseEntity{
	
	private String city;
	
	private String street;
	
	private String house;
	
}
