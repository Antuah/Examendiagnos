package mx.edu.utez.persona.model.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PersonaDto {
    private Integer id_persona;
    private String nombre;
    private String apellido;
    private String curp;
    private String fecha_nacimiento;
}
