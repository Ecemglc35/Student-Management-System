package ca.sheridancollege.gulec.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Long id; 
	@NonNull
	private String name;
	private Integer grade;
	private String letterGrade;
	private Boolean attended;
	private Boolean participated;
	
	public Student(String name, Integer grade,Boolean attended,Boolean participated) {
		super();
		this.name = name;
		this.grade = grade;
		this.letterGrade = assignLetterGrade(grade);
		this.attended = attended;
		this.participated = participated;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
		this.letterGrade = assignLetterGrade(grade);
	}
	
	private String assignLetterGrade(Integer grade) {
		if (grade >= 90)
			return "A+";
		else if (grade >= 85)
			return "A";
		else if (grade >= 80)
			return "A-";
		else if (grade >= 75)
			return "B+";
		else if (grade >= 70)
			return "B";
		else if (grade >= 65)
			return "C+";
		else if (grade >= 60)
			return "C";
		else if (grade >= 55)
			return "D+";
		else if (grade >= 50)
			return "D";
		else
			return "F";
	}

	
}
