package ua.springboot.web.entity;

import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REFRESH;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.springboot.web.enumaration.Role;

@Entity
@Table(name = "user")
@NoArgsConstructor
@Getter
@Setter
public class UserEntity extends BaseEntity{
	
	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_details_id", nullable = true)
	private UserDetails userDetails; 
	
	@Column(name = "token")
	private String token;
	
	@Column(name = "is_activated")
	private boolean isActivated;
	
	@Column(name = "recovery_key")
	private String recoveryKey;

	@Override
	public String toString() {
		return "UserEntity [email=" + email + ", password=" + password + ", role=" + role + ", userDetails="
				+ userDetails + ", token=" + token + ", isActivated=" + isActivated + ", recoveryKey=" + recoveryKey
				+ "]";
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	private List<History> history;
	
	
		
}