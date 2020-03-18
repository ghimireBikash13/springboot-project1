package com.cubic.services;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cubic.dtos.StudentDto;
import com.cubic.entities.StudentEntity;
import com.cubic.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public StudentDto getStudents(int id) {

		Optional<StudentEntity> studentEntity = studentRepository.findById(id);

		StudentDto dto = null;

		if (studentEntity.isPresent()) {
			dto = new StudentDto();
			dto.setId(studentEntity.get().getId());
			dto.setFirstName(studentEntity.get().getFirstName());
			dto.setLastName(studentEntity.get().getLastName());
			dto.setEmail(studentEntity.get().getEmail());
			dto.setPhone(studentEntity.get().getPhone());
		}
		return dto;

	}

	public void addStudents(StudentDto studentDto) {

		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setFirstName(studentDto.getFirstName());
		studentEntity.setLastName(studentDto.getLastName());
		studentEntity.setEmail(studentDto.getEmail());
		studentEntity.setPhone(studentDto.getPhone());
		studentEntity.setCreatedAt(new Date());
		studentEntity.setUpdatedAt(new Date());
		studentEntity.setUuid(UUID.randomUUID().toString());

		studentRepository.save(studentEntity);
	}

}