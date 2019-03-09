package org.izce.petclinic.services.map;

import org.izce.petclinic.model.Specialty;
import org.izce.petclinic.services.SpecialtyService;
import org.springframework.stereotype.Service;

@Service
public class SpecialtyServiceMap extends AbstractMapService<Specialty, Long> implements SpecialtyService {

}
