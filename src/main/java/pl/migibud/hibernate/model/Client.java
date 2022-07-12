package pl.migibud.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "client")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String firstName;
	private String lastName;

	@OneToMany(mappedBy = "client")
	private Set<Order> orders = new HashSet<>();

	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void addOrder(Order order){
		this.orders.add(order);
		order.setClient(this);
	}
}
