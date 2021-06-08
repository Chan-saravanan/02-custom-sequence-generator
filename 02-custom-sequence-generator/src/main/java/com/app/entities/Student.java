package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="STUDENT_X")
public class Student implements DomainObject<String>{
	@Id
	@GeneratedValue(generator="rollnumber-sequence-generator", strategy=GenerationType.SEQUENCE)
	@GenericGenerator(
        name = "rollnumber-sequence-generator",
        strategy = "com.app.entities.ids.generators.CustomSequenceNumberStringGenerator",
        parameters = {
            @org.hibernate.annotations.Parameter(
                name = "sequence_name", value = "X_ROLL_NUMBER_SEQ"),
            @org.hibernate.annotations.Parameter(
                name = "sequence_prefix", value = "CTC_"),
        }
    )
	@Column(name="ROLL_NO")
	private String id;
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private Integer age;
	
	@OneToOne
	@JoinColumn(name="ADDR_ID")
	private Address address;
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, Integer age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}



	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String t) {
		this.id = t;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
