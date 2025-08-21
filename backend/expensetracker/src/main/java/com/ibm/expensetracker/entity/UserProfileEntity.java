package com.ibm.expensetracker.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_profile")
public class UserProfileEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userProfileId;
	
	@Column(length = 100)
	private String firstName;
	
	@Column(length = 100)
	private String lastName;
	
	@Column(unique = true, nullable = false, length=25)
	private Long mobileNumber;
	
	@Column(length = 500)
	private String address;
	
	@OneToOne
	@JoinColumn(name="user_id",referencedColumnName ="userId" )
	private UsersEntity user;

	public UserProfileEntity() {
	
	}

	public UserProfileEntity(Long userProfileId, String firstName, String lastName, Long mobileNumber, String address,
			UsersEntity user) {
		super();
		this.userProfileId = userProfileId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.user = user;
	}

	public Long getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(Long userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UsersEntity getUser() {
		return user;
	}

	public void setUser(UsersEntity user) {
		this.user = user;
	}
	
	
	
}
