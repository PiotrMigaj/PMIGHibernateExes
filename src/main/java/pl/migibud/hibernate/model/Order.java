package pl.migibud.hibernate.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private float price;
	private String name;
	private LocalDateTime localDateTime;

	@ManyToOne
	@JoinColumn(name = "client_id")
	@ToString.Exclude
	private Client client;

	public Order(float price, String name, LocalDateTime localDateTime) {
		this.price = price;
		this.name = name;
		this.localDateTime = localDateTime;
	}
}
