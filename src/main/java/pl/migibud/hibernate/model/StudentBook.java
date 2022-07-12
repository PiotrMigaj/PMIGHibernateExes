package pl.migibud.hibernate.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "student_book")

@NoArgsConstructor
@Getter
@Setter
public class StudentBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String number;
	@OneToOne(mappedBy = "studentBook")
	Student student;

	public StudentBook(String number) {
		this.number = number;
	}

	public void setStudent(Student student){
		this.student = student;
		this.student.setStudentBook(this);
	}
}
