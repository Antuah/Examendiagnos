package mx.edu.utez.persona.model.dao;

import mx.edu.utez.persona.model.entity.PersonaBean;
import org.springframework.data.repository.CrudRepository;

public interface PersonaDao extends CrudRepository<PersonaBean, Integer> {
}
