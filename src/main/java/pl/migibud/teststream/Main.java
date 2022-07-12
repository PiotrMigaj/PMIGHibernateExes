package pl.migibud.teststream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {


	public static void main(String[] args) {

		Set<Employee> employees = new HashSet<>();

		employees.addAll(List.of(new Employee("Piotr"),new Employee("Anna"),new Employee("Basia")));

		System.out.println(employees);

		List<String> kasia = employees.stream().peek(v -> v.setName("Kasia")).map(Employee::getName).collect(Collectors.toList());

		System.out.println(employees);
		System.out.println(kasia);

	}
}
