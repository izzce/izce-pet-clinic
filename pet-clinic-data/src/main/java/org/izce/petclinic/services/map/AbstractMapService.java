package org.izce.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.izce.petclinic.model.BaseEntity;
import org.izce.petclinic.services.CrudService;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> implements CrudService<T, ID>{
	protected Map<Long, T> map = new HashMap<>();
	
	@Override
	public Set<T> findAll() {
		return new HashSet<T>(map.values());
	}
	
	@Override
	public T findById(ID id) {
		return map.get(id);
	}
	
	@Override
	public T save(T object) {
		if (object == null) {
			throw new IllegalArgumentException("null object cannot be saved!");
		}
		if (object.getId() == null) {
			object.setId(getNextId());
		}
		map.put(object.getId(), object);
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
	
	private Long getNextId() {
		if (map.isEmpty()) {
			return 1L;
		} else {
			return Collections.max(map.keySet()) + 1L;
		}
	}
}
