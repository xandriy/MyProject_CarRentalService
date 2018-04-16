package ua.springboot.web.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_details")
@NoArgsConstructor
@Getter
@Setter
public class UserDetails extends BaseEntity{

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "year_of_birth")
	private int yearOfBirth;
	
	@Column(name = "license_number")
	private String licenseNumber;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "photoPath")
	private String photoPath;
	
	@OneToOne(mappedBy = "userDetails", cascade = CascadeType.ALL)
	private UserEntity userEntity;

	@Override
	public String toString() {
		return "UserDetails [firstName=" + firstName + ", lastName=" + lastName + ", phoneNumber=" + phoneNumber
				+ ", yearOfBirth=" + yearOfBirth + ", licenseNumber=" + licenseNumber + ", passportNumber="
				+ passportNumber + ", photoPath=" + photoPath + ", userEntity=" + userEntity + "]";
	}
	
	
	
}
