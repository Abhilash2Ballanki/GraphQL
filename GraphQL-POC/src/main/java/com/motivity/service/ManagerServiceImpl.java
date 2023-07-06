package com.motivity.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motivity.entity.Employee;
import com.motivity.entity.Manager;
import com.motivity.repository.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService{
	
	@Autowired
	private ManagerRepository managerRepository;

	@Override
	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	@Override
	public List<Manager> getAll() {
		return managerRepository.findAll();
	}

	@Override
	public List<Manager> saveAllManagers(List<Manager> managers) {
		return managerRepository.saveAll(managers);
	}

	@Override
	public List<Employee> getEmployeeByManagerId(int managerId) {
		Manager manager = managerRepository.findById(managerId)
				.orElseThrow(() -> new RuntimeException("Manager is not found"));
		List<Employee> employees = manager.getEmployees();
		return employees;
	}

	@Override
	public Manager getByManagerId(int managerId) {
		return managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager is not found"));
	}

	@Override
	public Manager assignEmployeesForManager(int managerId,List<Employee> employees) {
		Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new RuntimeException("Manager is not found"));
		manager.getEmployees().addAll(employees);
		Manager updatedManager = managerRepository.save(manager);
		return updatedManager;
	}

	@Override
	public Manager getManagerByEmployeeId(int employeeId) {
		return managerRepository.findManagerByEmployeeId(employeeId);
	}

}
