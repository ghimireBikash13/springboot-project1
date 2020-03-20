package com.cubic.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

	public List<StudentDto> getAllStudents() {

		Iterable<StudentEntity> studentEntity = studentRepository.findAll();

		List<StudentDto> studentDto = new ArrayList<StudentDto>();

		for (StudentEntity student : studentEntity) {
			StudentDto studentDto1 = new StudentDto();
			studentDto1.setId(student.getId());
			studentDto1.setFirstName(student.getFirstName());
			studentDto1.setLastName(student.getLastName());
			studentDto1.setEmail(student.getEmail());
			studentDto1.setPhone(student.getPhone());

			studentDto.add(studentDto1);

		}
		return studentDto;

	}

	public void updateStudents(int id, StudentDto studentDto) {
		Optional<StudentEntity> studentEntity = studentRepository.findById(id);

		if (studentEntity.isPresent()) {
			StudentEntity studentEntity2 = studentEntity.get();
			studentEntity2.setFirstName(studentDto.getFirstName());
			studentEntity2.setLastName(studentDto.getLastName());
			studentEntity2.setEmail(studentDto.getEmail());
			studentEntity2.setPhone(studentDto.getPhone());

			studentRepository.save(studentEntity2);
		}
	}

}