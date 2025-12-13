package pe.com.yuntasburguer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

@Entity
@Table(name = "Empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id;

    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String cargo;

    @Column(columnDefinition = "TINYINT DEFAULT 1")
    private Boolean estado;
}
