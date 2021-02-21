package org.izce.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "types")
public class PetType extends BaseEntity {
	@Column(name = "name")
	private String name;

	@Builder
	public PetType(Long id, String name) {
		super(id);
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
