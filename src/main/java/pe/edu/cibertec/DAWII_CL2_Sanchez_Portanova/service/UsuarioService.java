package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.repository.EspecialidadRepository;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd.Usuario;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.repository.UsuarioRepository;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder
            = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorNomusuario(String nomUsuario){
        return usuarioRepository.findByNomusuario(nomUsuario);
    }
    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassusuario(bCryptPasswordEncoder
                .encode(usuario.getPassusuario()));
        Especialidad especialidad = especialidadRepository.findByNomesp("IDIOMAS");
        usuario.setEspecialidads(new HashSet<Especialidad>(Arrays.asList(especialidad)));

        return usuarioRepository.save(usuario);
    }}