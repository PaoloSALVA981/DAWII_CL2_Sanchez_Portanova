package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "nomusuario")
    private String nomusuario;
    @Column(name = "passusuario")
    private String passusuario;

    @ManyToMany(cascade =  CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(name = "especialidad",
            joinColumns = @JoinColumn(name = "idusuario"),
            inverseJoinColumns = @JoinColumn(name = "idesp"))
    private Set<Especialidad> especialidads;

}


