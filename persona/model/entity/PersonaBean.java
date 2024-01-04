package mx.edu.utez.persona.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@ToString
@Table(name = "personas")
public class PersonaBean {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "persona_id")
        private Integer persona_id;

        @Column(name = "nombre")
        private String nombre;

        @Column(name = "apellido")
        private String apellido;

        @Column(name = "fecha_nacimiento")
        private String fecha_nacimiento;

        @Column(name = "curp")
        private String curp;

}
