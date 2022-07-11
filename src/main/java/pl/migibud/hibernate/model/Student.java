package pl.migibud.hibernate.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")

@NoArgsConstructor
@Getter
@Setter

public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String firstName;
	String lastName;
	LocalDate localDate;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "student_book_id")
	StudentBook studentBook;


	public Student(String firstName, String lastName, LocalDate localDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.localDate = localDate;
	}
}
