package mx.edu.utez.persona.service.Impl;


import lombok.AllArgsConstructor;
import mx.edu.utez.persona.model.dao.PersonaDao;
import mx.edu.utez.persona.model.dto.PersonaDto;
import mx.edu.utez.persona.model.entity.PersonaBean;
import mx.edu.utez.persona.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ImplPersona implements IPersona {
    @Autowired
    private final PersonaDao personaDao;

    @Override
    @Transactional
    public PersonaBean save(PersonaDto personaDto) {
        PersonaBean persona = PersonaBean.builder()
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .fecha_nacimiento(personaDto.getFecha_nacimiento())
                .curp(personaDto.getCurp())
                .build();
        return personaDao.save(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonaBean findById(Integer id) {
        return personaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonaBean> findAll() {
        return (List<PersonaBean>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void delete(PersonaBean personaBean) {
        personaDao.delete(personaBean);
    }
}
