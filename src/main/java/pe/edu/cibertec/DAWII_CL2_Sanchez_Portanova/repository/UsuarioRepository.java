package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd.Usuario;

@Repository
public interface UsuarioRepository
    extends JpaRepository<Usuario, Integer> {


    Usuario findByNomusuario(String nomusuario);

}
