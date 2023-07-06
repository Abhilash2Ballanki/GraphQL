package com.motivity.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee_table")
public class Employee {
	
	@Id
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private String empCode;
	private String address;
	private String businessLine;


}
