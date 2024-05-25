function getStudentInfo(id){
	document.getElementsByTagName('a')[0].style.backgroundColor = "red";
	if(document.getElementById("student" + id).innerHTML == ""){
		fetch('http://localhost:8080/api/v1/students/' + id)
		.then(student => student.json())
		.then(student => {
			var textToDisplay = "";
				textToDisplay += "Grade: " + student.grade + "<br>";
				textToDisplay += "Letter Grade: " + student.letterGrade + "<br>";
				textToDisplay += "Attended: " + student.attended + "<br>";
				textToDisplay += "Participated: " + student.participated + "<br>";
				
				document.getElementById("student" + id).innerHTML = textToDisplay;
		});
	}else {
		document.getElementById("student" + id).innerHTML = "";
	}
}