package org.izce.petclinic.data.services;

import java.util.Set;

import org.izce.petclinic.data.model.Owner;

public interface CrudService<T, ID> {

	Set<T> findAll();

	T findById(ID Id);

	T save(T object);

	void delete(T object);

	void deleteById(ID id);
}
