CREATE TABLE student(
	id LONG PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(255),
	grade INTEGER,
	letterGrade VARCHAR(2),
	attended BIT,
	participated BIT
);