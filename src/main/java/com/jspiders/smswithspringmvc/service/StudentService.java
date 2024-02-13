package com.jspiders.smswithspringmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.smswithspringmvc.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc.repository.StudentRepository;

@Component
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;

	public void addStudent(String name, String email, long mobile, byte age) {

		StudentPOJO studentPOJO = new StudentPOJO();

		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMobile(mobile);
		studentPOJO.setAge(age);
		studentRepository.addStudent(studentPOJO);

//			studentRepository.addStudent(String name, String email, long mobile , byte age);

	}

	public List<StudentPOJO> getAllStudent() {
		return studentRepository.getAllStudent();
	}

	public String deleteStudent(int id) {
		// TODO Auto-generated method stub

		StudentPOJO deleteIdStudent = null;

		List<StudentPOJO> students = studentRepository.getAllStudent();

		for (StudentPOJO student : students) {

			if (student.getId() == id) {

				deleteIdStudent = student;
			}
		}

		if (deleteIdStudent == null) {

			return "Student Not Found.";
		} else {

			studentRepository.deleteStudent(deleteIdStudent);
			return "Student Deleted.";

		}

	}

	public StudentPOJO editStudent(int id) {

		StudentPOJO editStudentId = null;

		List<StudentPOJO> students = studentRepository.getAllStudent();

		for (StudentPOJO student : students) {

			if (student.getId() == id) {

				editStudentId = student;
				break;
			}
		}

		return editStudentId;
	}

	public void updateStudent(long id, String name, String email, long mobile, byte age) {

		StudentPOJO studentPOJO = studentRepository.getStudentById(id);
		studentPOJO.setId(id);
		studentPOJO.setName(name);
		studentPOJO.setEmail(email);
		studentPOJO.setMobile(mobile);
		studentPOJO.setAge(age);
		studentRepository.addStudent(studentPOJO);
		
		
	}

	public List<StudentPOJO> getStudentByPattern(String pattern) {
		
		return studentRepository.getStudentByPattern(pattern);
		
		
	}
}
