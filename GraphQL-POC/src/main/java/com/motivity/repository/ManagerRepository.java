package com.motivity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.motivity.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

	@Query(value = "SELECT * FROM manager_table INNER JOIN employee_table "
			+ "ON manager_table.manager_id = employee_table.manager_id_fk WHERE employee_table.employee_id = :employeeId", nativeQuery = true)
	Manager findManagerByEmployeeId(int employeeId);
	
}
