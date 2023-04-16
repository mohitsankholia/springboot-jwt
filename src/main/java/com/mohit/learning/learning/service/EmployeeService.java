package com.mohit.learning.learning.service;

import java.util.List;

import com.mohit.learning.learning.dto.EmployeeDTO;
import com.mohit.learning.learning.entity.Employee;

public interface EmployeeService {

	void saveEmployee(EmployeeDTO employeeDTO) throws Exception;

	void updateEmployee(Employee employee);

	Employee findEmployeeById(Integer id);

	void deleteEmployeeById(Integer id);

	List<Employee> listOfEmployees();

//	List<Employee> findEmployeeByName(String name);
//	
//	List<Employee> findEmployeeByIdAndName(Integer id, String name);
//	
//	List<Employee> findEmployeeByNameStartingWithS(String name);

	List<Employee> getAllEmployee();

	List<Employee> getEmployeeByName(String name);

	List<Employee> getEmployeeBySalary();

	List<Employee> getEmployeeByNameAndSalary(String name, Integer salary);

	List<Employee> getEmployeeByNameStartingWith(String name);

	List<Employee> getEmployeeBySalaryBetween();

	List<Employee> getEmployeeBySalaryBetweenTwo(Integer startsalary, Integer endsalary);

	List<Employee> getEmployeeByNameAndAge(String name, Integer startage, Integer endage);

}
