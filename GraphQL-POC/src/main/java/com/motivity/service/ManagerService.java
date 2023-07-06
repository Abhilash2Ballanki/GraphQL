package com.motivity.service;

import java.util.List;

import com.motivity.entity.Employee;
import com.motivity.entity.Manager;

public interface ManagerService {
	
	 Manager saveManager(Manager manager);
	
	 List<Manager> getAll();
	 
	 List<Manager> saveAllManagers(List<Manager> managers);

	 List<Employee> getEmployeeByManagerId(int managerId);
	 
	 Manager getByManagerId(int managerId);
	 
	 Manager assignEmployeesForManager(int managerId,List<Employee> employees);
	 
	 Manager getManagerByEmployeeId(int employeeId);

}
