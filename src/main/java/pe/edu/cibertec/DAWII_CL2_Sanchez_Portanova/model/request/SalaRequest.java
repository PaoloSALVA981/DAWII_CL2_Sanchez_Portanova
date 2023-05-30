package pe.edu.cibertec.appformsbasedatos.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaRequest {
    private Integer idsala;
    private String descsala;
    private Integer asientos;
    private Integer idestado;
}
