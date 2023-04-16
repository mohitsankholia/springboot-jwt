package com.mohit.learning.learning.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.learning.learning.entity.Department;
import com.mohit.learning.learning.exceptions.CustomExceptions;
import com.mohit.learning.learning.service.DepartmentService;
import com.mohit.learning.learning.utils.ApplicationUtils;

@RestController
@RequestMapping("/admin/department")
public class DepartmentController {

	private static Logger LOGGER = LogManager.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/save")
	public ResponseEntity<Object> saveDepartment(@RequestBody Department department) {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + department.toString());

		departmentService.saveDepartment(department);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Object> updateDepartment(@RequestBody Department department) {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + department.toString());

		departmentService.updateDepartment(department);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/fetchbyid")
	public ResponseEntity<Object> findDepartmentById(@RequestParam Integer id) throws CustomExceptions {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + id.toString());

		Department department = departmentService.findDepartmentById(id);
		return new ResponseEntity<>(department, HttpStatus.FOUND);
	}

	@DeleteMapping("/deletebyid")
	public ResponseEntity<Object> deleteDepartmentById(@RequestParam Integer id) {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + id.toString());

		departmentService.deleteDepartmentById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/fetchall")
	public ResponseEntity<Object> listOfDepartments() {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, ");

		List<Department> department = departmentService.listOfDepartments();
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@GetMapping("/fetchbyname")
	public ResponseEntity<Object> findDepartmentByName(@RequestParam String name) {

		LOGGER.info(ApplicationUtils.CLASSNAME + this.getClass().getSimpleName() + ", " + ApplicationUtils.METHODNAME
				+ "departmentService, " + ApplicationUtils.REQUESTPARAMETERS + name.toString());

		List<Department> department = departmentService.findDepartmentByName(name);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

}
