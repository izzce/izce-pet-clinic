package org.izce.petclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
	private String name;
	private PetType petType;
	private Owner owner;
	private LocalDate birthday;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public PetType getPetType() {
		return petType;
	}

	public void setPetType(PetType petType) {
		this.petType = petType;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}