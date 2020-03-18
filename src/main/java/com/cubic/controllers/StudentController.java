package com.cubic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.dtos.StudentDto;
import com.cubic.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/{id}")
	public StudentDto getStudentsInfo(@PathVariable int id) {

		return studentService.getStudents(id);

	}

	@PostMapping(value = "")
	public void addStudentInfo(@RequestBody StudentDto dtos) {
		studentService.addStudents(dtos);
	}
}
