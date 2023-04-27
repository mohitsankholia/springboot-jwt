package com.mohit.spring_jwt.service;

import java.util.List;

import com.mohit.spring_jwt.entity.Department;
import com.mohit.spring_jwt.exceptions.CustomExceptions;

public interface DepartmentService {

	void saveDepartment(Department employee);

	void updateDepartment(Department employee);

	Department findDepartmentById(Integer id) throws CustomExceptions;

	void deleteDepartmentById(Integer id);

	List<Department> listOfDepartments();

	List<Department> findDepartmentByName(String name);

}
