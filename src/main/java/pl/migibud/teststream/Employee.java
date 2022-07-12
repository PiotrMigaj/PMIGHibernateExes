package pl.migibud.teststream;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;

@EqualsAndHashCode
@Setter
@Getter
public class Employee {

	String name;

	public Employee(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"name='" + name + '\'' +
				'}';
	}
}
