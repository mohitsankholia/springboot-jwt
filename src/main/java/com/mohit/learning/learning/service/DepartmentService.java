package com.mohit.learning.learning.service;

import java.util.List;

import com.mohit.learning.learning.entity.Department;
import com.mohit.learning.learning.exceptions.CustomExceptions;

public interface DepartmentService {

	void saveDepartment(Department employee);

	void updateDepartment(Department employee);

	Department findDepartmentById(Integer id) throws CustomExceptions;

	void deleteDepartmentById(Integer id);

	List<Department> listOfDepartments();

	List<Department> findDepartmentByName(String name);

}
