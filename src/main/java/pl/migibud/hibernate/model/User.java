package pl.migibud.hibernate.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	String username;
	String password;
	@JoinColumn(name = "address_id")
	@OneToOne(cascade = CascadeType.ALL)
	Address address;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}


}
