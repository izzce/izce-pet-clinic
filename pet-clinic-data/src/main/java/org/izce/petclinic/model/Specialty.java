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
@Builder
@Entity
@Table(name="specialties")
public class Specialty extends BaseEntity {

	@Column(name="description")
	private String description;

	@Builder
	public Specialty(Long id, String description) {
		super(id);
		this.description = description;
	}
}
