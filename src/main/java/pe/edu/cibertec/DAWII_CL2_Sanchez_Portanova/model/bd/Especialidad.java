package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "especialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idesp;
    @Column(name = "nomesp")
    private String nomesp;
    @Column(name = "costo")
    private BigDecimal costo;
}
