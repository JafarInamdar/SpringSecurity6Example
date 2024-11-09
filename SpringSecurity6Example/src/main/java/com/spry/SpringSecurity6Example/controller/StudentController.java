package com.spry.SpringSecurity6Example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spry.SpringSecurity6Example.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<Student>(
			List.of(new Student(1, "sahil", 98), new Student(2, "Om", 85), new Student(3, "Sham", 75)

			));

	@GetMapping("/students")
	public List<Student> students() {
		return students;
	}

	@GetMapping("/csrf-token")
	public CsrfToken getCsrfTokent(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}

	@PostMapping("/students")
	public Student addStudent(@RequestBody Student student) {
		students.add(student);
		return student;
	}

}