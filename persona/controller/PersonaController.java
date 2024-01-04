package mx.edu.utez.persona.controller;
import mx.edu.utez.persona.model.dto.PersonaDto;
import mx.edu.utez.persona.model.entity.PersonaBean;
import mx.edu.utez.persona.service.IPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v4/persona")
public class PersonaController {
    @Autowired
    private IPersona personaService;

    @GetMapping("/")
    public List<PersonaBean> getCards() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public PersonaBean showById(@PathVariable Integer id) {
        return personaService.findById(id);
    }

    @PostMapping("/")
    public PersonaDto create(@RequestBody PersonaDto personaDto) {
        PersonaBean personaSave = personaService.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaSave.getPersona_id())
                .nombre(personaSave.getNombre())
                .apellido(personaSave.getApellido())
                .fecha_nacimiento(personaSave.getFecha_nacimiento())
                .curp(personaSave.getCurp())
                .build();
    }
    @PutMapping("/")
    public PersonaDto update(@RequestBody PersonaDto personaDto) {
        PersonaBean personaUpdate = personaService.save(personaDto);
        return PersonaDto.builder()
                .id_persona(personaDto.getId_persona())
                .nombre(personaDto.getNombre())
                .apellido(personaDto.getApellido())
                .fecha_nacimiento(personaDto.getFecha_nacimiento())
                .curp(personaDto.getCurp())
                .build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map<String, Object> response = new HashMap<>();
        try {
            PersonaBean  personaDelete= personaService.findById(id);
            personaService.delete(personaDelete);
            return new ResponseEntity<>(personaDelete, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Borrado correctamente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}