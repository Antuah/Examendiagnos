package mx.edu.utez.persona.service;


import mx.edu.utez.persona.model.entity.PersonaBean;
import mx.edu.utez.persona.model.dto.PersonaDto;
import java.util.List;

public interface IPersona {
    PersonaBean save(PersonaDto personaDto);

    PersonaBean findById(Integer id);

    List<PersonaBean> findAll();

    void delete(PersonaBean personaBean);
}
