package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResultadoResponse {
    private Boolean respuesta;
    private String mensaje;
}
