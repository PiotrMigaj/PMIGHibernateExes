package pl.migibud.hibernate.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "address")

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String street;
	String city;
	@OneToOne(mappedBy = "address")
	@ToString.Exclude
	User user;

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public void setUser(User user){
		this.user = user;
		this.user.setAddress(this);
	}
}
