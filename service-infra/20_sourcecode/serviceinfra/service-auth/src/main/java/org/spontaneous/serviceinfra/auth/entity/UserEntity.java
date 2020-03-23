package org.spontaneous.serviceinfra.auth.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.spontaneous.serviceinfra.auth.service.api.Gender;
import org.spontaneous.serviceinfra.auth.service.api.User;


@Entity
@Table(name="USERS")
public class UserEntity implements User, Serializable {
	
	private static final long serialVersionUID = -7447873502288352919L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstname;
	
	private String lastname;
	
	@Column(unique=true)
	private String email;
	
	private String password;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	private byte [] image;
	
	@ManyToMany(fetch = FetchType.EAGER) //, cascade=CascadeType.ALL)
	private List<RoleEntity> roles;

	public UserEntity() {
		;
	}

	public UserEntity(String firstname, String lastname, String email, String password, List<RoleEntity> roles, Gender gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.gender = gender;
	}
	
	public UserEntity(String firstname, String lastname, String email, String password, List<RoleEntity> roles, Gender gender, byte [] image) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.gender = gender;
		this.image = image;
	}

	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
