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
@Table(name = "Mesas")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mesa")
    private Integer id;

    private Integer numero;

    @Enumerated(EnumType.STRING)
    private EstadoMesa estado;

    public enum EstadoMesa {
        Libre, Ocupada
    }
}
