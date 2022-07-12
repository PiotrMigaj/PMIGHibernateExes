package pl.migibud.hibernate2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.migibud.hibernate.model.Order;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "client")

@NoArgsConstructor
@Getter
@Setter
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstName;
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "clients")
	private List<Orders> orders = new ArrayList<>();

	public Client(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Orders addOrder(Orders orders){
		this.orders.add(orders);
		orders.getClients().add(this);
		return orders;
	}
}
