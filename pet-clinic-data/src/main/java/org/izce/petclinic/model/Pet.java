package org.izce.petclinic.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.izce.petclinic.model.Owner.OwnerBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {
	@Column(name = "name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "type_id")
	private PetType petType;
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;
	@Column(name = "birth_date")
	private LocalDate birthdate;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="pet")
	private final Set<Visit> visits = new HashSet<Visit>();
	
	@Builder
	public Pet(Long id, String name, PetType petType, Owner owner, LocalDate birthdate) {
		super(id);
		this.name = name;
		this.petType = petType;
		this.owner = owner;
		this.birthdate = birthdate;
	}
	
	
}