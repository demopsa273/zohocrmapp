package com.zohocrmapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contact extends AbstractClass {
	
@Column(name = "first_name",nullable = false,length = 125)	
private String firstName;

@Column(name = "last_name",nullable = false,length = 125)	
private String lastName;

@Column(name = "email",nullable = false,unique = true,length = 35)	
private String email;

@Column(name = "mobile",nullable = false,unique = true,length = 10)
private Long mobile;

private String source;

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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public Long getMobile() {
	return mobile;
}

public void setMobile(Long mobile) {
	this.mobile = mobile;
}

public String getSource() {
	return source;
}

public void setSource(String source) {
	this.source = source;
}


}
