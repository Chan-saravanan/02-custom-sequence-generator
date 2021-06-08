package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ADDRESS_X")
public class Address implements DomainObject<String>{
	@Id
	@GeneratedValue(generator="address-sequence-generator", strategy=GenerationType.SEQUENCE)
	@GenericGenerator(
	        name = "address-sequence-generator",
	        strategy = "com.app.entities.ids.generators.CustomSequenceNumberStringGenerator",
	        parameters = {
	            @org.hibernate.annotations.Parameter(
	                name = "sequence_name", value = "X_ADDRESS_SEQUENCE"),
	            @org.hibernate.annotations.Parameter(
	                name = "sequence_prefix", value = "CTC_"),
	        }
	    )
	@Column(name="ADDR_ID")
	private String id;
	@Column(name="CITY")
	private String city;
	@Column(name="STATE")
	private String state;
	
	
	public Address(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String t) {
		this.id = t;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", state=" + state + "]";
	}
}
