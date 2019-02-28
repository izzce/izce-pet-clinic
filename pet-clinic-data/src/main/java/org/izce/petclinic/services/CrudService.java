package org.izce.petclinic.services;

import java.util.Set;


public interface CrudService<T, ID> {

	Set<T> findAll();

	T findById(ID Id);

	T save(T object);

	void delete(T object);

	void deleteById(ID id);
}
