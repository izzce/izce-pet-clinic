package org.izce.petclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.izce.petclinic.services.CrudService;

public abstract class AbstractMapService<T, ID> implements CrudService<T, ID>{
	protected Map<ID, T> map = new HashMap<>();
	
	@Override
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}
	
	@Override
	public T findById(ID id) {
		return map.get(id);
	}
	
	T save(ID id, T object) {
		map.put(id, object);
		return object;
	}
	
	@Override
	public void deleteById(ID id) {
		map.remove(id);
	}
	
	@Override
	public void delete(T object) {
		map.entrySet().removeIf(e -> e.getValue().equals(object));
	}
}
