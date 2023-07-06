package com.motivity.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Manager_Table")
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manager_Id")
	private int managerId;
	private String managerFirstName;
	private String managerLastName;
	private String salary;
	private String managerCode;
	private String phone;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_Id_fk",referencedColumnName = "manager_Id")
	private List<Employee> employees;

}
