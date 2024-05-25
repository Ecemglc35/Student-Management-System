package ca.sheridancollege.gulec.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.gulec.beans.Student;
import ca.sheridancollege.gulec.database.DatabaseAccess;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
	
	//@Autowired
	private DatabaseAccess da;
	
	
	@GetMapping
	public List<Student> getStudentCollection(){
		return da.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public Student getIndividualStudent(@PathVariable Long id) {
		return da.findByID(id);
	}
	
	@PostMapping(consumes = "application/json")
	public String postStudent(@RequestBody Student student) {
		return "http://localhost:8080/api/v1/students/" + da.saveStudent(student);
	}
	
	@PutMapping(consumes = "application/json")
	public String putStudentCollection(@RequestBody List<Student> students) {
		da.deleteAll();
		
		da.saveAll(students);
		
		return "The record count is " + da.count();
	}
	
	@DeleteMapping(value = "/{id}")
	public String putStudent(@PathVariable Long id) {
		da.deleteIndividual(id);
		
		return "Deleted one student";
	}
	
	@DeleteMapping(consumes = "application/json")
	public String deleteAllCollection() {
		da.deleteAll();
		
		return "All collection deleted";
	}
	
	
	
	
	
	
}
