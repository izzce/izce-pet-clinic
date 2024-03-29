package org.izce.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vets")
public class Vet extends Person {
	private static final long serialVersionUID = -1685422323674330809L;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="vet_specialties", joinColumns= @JoinColumn(name="vet_id"), 
	inverseJoinColumns=@JoinColumn(name="specialty_id"))
	private Set<Specialty> specialties = new HashSet<Specialty>();

	@Builder 
	public Vet(Long id, String firstName, String lastName) {
		super(id, firstName, lastName);
	}

}
