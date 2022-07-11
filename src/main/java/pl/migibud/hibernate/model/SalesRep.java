package pl.migibud.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sales_rep")

@NoArgsConstructor
@Getter
@Setter
public class SalesRep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;

	@OneToMany(mappedBy = "salesRep",cascade = CascadeType.ALL)
	Set<Customer> customers = new HashSet<>();

	public SalesRep(String name) {
		this.name = name;
	}

	public void addCustomer(Customer customer){
		this.customers.add(customer);
//		customer.setSalesRep(this);
	}
}
