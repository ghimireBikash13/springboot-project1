package com.cubic.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("/email/{email}")
	public StudentDto getStudentByEmail(@PathVariable("email") String emailAddress) {
		return studentService.findStudentByEmail(emailAddress);

	}

	@PostMapping(value = "")
	public void addStudentInfo(@RequestBody StudentDto dtos) {
		studentService.addStudents(dtos);
	}

	@GetMapping(value = "")
	public List<StudentDto> getStudents() {

		return studentService.getAllStudents();

	}

	@PutMapping(value = "update/{id}")
	public void updateStudentInfo(@PathVariable("id") int id, @RequestBody StudentDto studentDto) {
		studentService.updateStudents(id, studentDto);
	}
}
