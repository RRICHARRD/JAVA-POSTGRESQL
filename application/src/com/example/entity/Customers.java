package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Customer")
public final class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * At postgresql database, I made some configurations to 
	 * save some informations by insert id manually 
	 * Identity -> by default
	 * Increment -> 1
	 * Start -> 0
	 * Minimun -> 0
	 * Maximum -> 0
	 * Cache -> 900
	 */
	@Column(name = "id")
	public Integer id;
	
	@Column(name = "name")
	public String name;
	
	@Column(name = "age")
	public int age;
	
	@Column(name = "address")
	public String address;
	
	@Column(name = "salary")
	public double salary;
	
	public Customers() {}
	
	public Customers(Integer id, String name, int age, String address, double salary) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public double getSalary() {
		return this.salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
}
