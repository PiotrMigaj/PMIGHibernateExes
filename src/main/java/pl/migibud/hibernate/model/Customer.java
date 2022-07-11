package pl.migibud.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "customer")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String name;
	@JoinColumn(name = "sales_rep_id")
	@ManyToOne
	SalesRep salesRep;

	public Customer(String name) {
		this.name = name;
	}
}
