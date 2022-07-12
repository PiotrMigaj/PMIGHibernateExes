package pl.migibud.hibernate2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")

@NoArgsConstructor
@Getter
@Setter

public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private float price;
	private String name;
	private LocalDateTime localDateTime;

	@ManyToMany
	@JoinTable(
			name = "orders_client",
			joinColumns = @JoinColumn(name = "oders_id"),
			inverseJoinColumns = @JoinColumn(name = "client_id")
	)
	private Set<Client> clients = new HashSet<>();

	public Orders(float price, String name, LocalDateTime localDateTime) {
		this.price = price;
		this.name = name;
		this.localDateTime = localDateTime;
	}
}
