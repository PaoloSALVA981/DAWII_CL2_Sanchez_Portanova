package pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd.Especialidad;
import pe.edu.cibertec.DAWII_CL2_Sanchez_Portanova.model.bd.Usuario;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioDetalleService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.buscarUsuarioPorNomusuario(username);
        return usuarioPorAutenticacion(usuario,
                obtenerAutorizacionUsuario(usuario.getEspecialidads()));
    }
    private List<GrantedAuthority> obtenerAutorizacionUsuario(Set<Especialidad> listRoles){
        Set<GrantedAuthority> especialidads = new HashSet<GrantedAuthority>();
        for (Especialidad especialidad : listRoles) {
            especialidads .add(new SimpleGrantedAuthority(especialidad.getNomesp()));
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(especialidads);
        return grantedAuthorities;
    }
    private UserDetails usuarioPorAutenticacion(Usuario usuario,
                                                List<GrantedAuthority> authorityList){
        return new User(usuario.getNomusuario(),
                usuario.getPassusuario(),authorityList) ;



}}
