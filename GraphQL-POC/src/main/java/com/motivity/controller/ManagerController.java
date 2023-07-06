package com.motivity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.motivity.dto.ManagerInput;
import com.motivity.entity.Employee;
import com.motivity.entity.Manager;
import com.motivity.service.ManagerService;

@Controller
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@MutationMapping("saveManager")
	public Manager saveManager(@Argument ManagerInput manager){
		Manager manager1 = new Manager();
		manager1.setManagerFirstName(manager.getManagerFirstName());
		manager1.setManagerLastName(manager.getManagerLastName());
		manager1.setManagerCode(manager.getManagerCode());
		manager1.setPhone(manager.getPhone());
		manager1.setSalary(manager.getSalary());
		manager1.setEmployees(manager.getEmployees());
		return managerService.saveManager(manager1);
	}
	
	@QueryMapping("getAll")
	public List<Manager> getAll(){
		return managerService.getAll();
	}
	
	@MutationMapping("saveAllManagers")
	public List<Manager> saveAllManagers(@Argument List<Manager> managers){
		return managerService.saveAllManagers(managers);
	}
	
	@QueryMapping("getAllEmployeesByManagerId")
	public List<Employee> getAllEmployeesByManagerId(@Argument int managerId){
		return managerService.getEmployeeByManagerId(managerId);
	}
	
	@QueryMapping("getByManagerId")
	public Manager getByManagerId(@Argument int managerId) {
		return managerService.getByManagerId(managerId);
	}
	
	@MutationMapping("assignEmployeesToManager")
	public Manager assignEmployeesToManager(@Argument int managerId,@Argument List<Employee> employees) {
		return managerService.assignEmployeesForManager(managerId, employees);
	}
	
	@QueryMapping("getManagerByEmployeeId")
	public Manager getManagerByEmployeeId(@Argument int employeeId) {
		return managerService.getManagerByEmployeeId(employeeId);
	}

}
