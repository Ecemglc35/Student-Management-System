package ca.sheridancollege.gulec.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.gulec.beans.Student;

@Repository
public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	//find all student and return as list 
	public List<Student> findAll(){
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String query = "SELECT * FROM student";
		
		 return jdbc.query(query, param, new BeanPropertyRowMapper<Student>(Student.class));
		
	}
	
	//Find student by id return student 
	public Student findByID(Long id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String query = "SELECT * FROM student WHERE id = :id";
		param.addValue("id", id);
		
		return jdbc.queryForObject(query, param, new BeanPropertyRowMapper<Student>(Student.class));
		
	}
	//save student
	public Long saveStudent(Student student) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		//to hold incremented student id 
		KeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		
		
		String query = "INSERT INTO student(name, grade, letterGrade, attended, participated) "
				+ "VALUES(:name, :grade, :letterGrade, :attended, :participated)";
		param.addValue("name", student.getName())
		.addValue("grade", student.getGrade())
		.addValue("letterGrade", student.getLetterGrade())
		.addValue("attended", student.getAttended())
		.addValue("participated", student.getParticipated());
		
		jdbc.update(query, param, generatedKeyHolder);
		
		return (Long)generatedKeyHolder.getKey();
	}
	
	//delete all students 
	public void deleteAll() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String query = "DELETE FROM student";
		
		jdbc.update(query, param);
	}
	
	//count all students 
	public Long count() {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String query = "SELECT count(*) FROM student";
		
		return jdbc.queryForObject(query, param, Long.TYPE);
	}
	
	//save all student into a list 
	public void saveAll(List<Student> students) {
		for(Student student : students) {
			saveStudent(student);
		}
	}
	
	public void deleteIndividual(Long id) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		
		String query = "DELETE FROM student WHERE id = :id";
		param.addValue("id", id);
		
		jdbc.update(query, param);
	}
	
}
