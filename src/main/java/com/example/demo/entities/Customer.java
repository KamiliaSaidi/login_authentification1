package com.example.demo.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Customer implements Serializable {

	@Id @GeneratedValue
	private Long id;
	private String Name; 
	private String Address;
	private String phone;  
	private String birth;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String name, String address, String phone, String birth) {
		super();
		Name = name;
		Address = address;
		this.phone = phone;
		this.birth = birth;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

 
	
    public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	


	
	
}
