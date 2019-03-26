package org.izce.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="owners")
public class Owner extends Person {
	@Column(name="address")
	private String address;
	@Column(name="city")
	private String city;
	@Column(name="telephone")
	private String telephone;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="owner")
	private final Set<Pet> pets = new HashSet<Pet>();
	
	@Builder 
	public Owner(Long id, String firstName, String lastName, String address, String city, String telephone) {
		super(id, firstName, lastName);
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	
	
	

}
