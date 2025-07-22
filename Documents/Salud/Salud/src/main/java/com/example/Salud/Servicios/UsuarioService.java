package com.example.Salud.Servicios;

import com.example.Salud.Entidades.Rol;
import com.example.Salud.Entidades.Usuario;
import com.example.Salud.Repositorios.RolRepository;
import com.example.Salud.Repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public Optional<Usuario> login(String username, String password) {
        return usuarioRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }

    public Usuario registrarUsuario(Usuario usuario, String rolNombre) {
        if (usuarioRepository.findByDni(usuario.getDni()).isPresent()) {
            throw new IllegalStateException("El DNI ya está registrado");
        }
        if (usuarioRepository.findByUsername(usuario.getUsername()).isPresent()) {
            throw new IllegalStateException("El nombre de usuario ya está en uso");
        }

        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new IllegalStateException("Rol no encontrado"));
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarPorRol(String rolNombre) {
        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new IllegalStateException("Rol no encontrado"));
        return usuarioRepository.findAll().stream()
                .filter(u -> u.getRol().getId().equals(rol.getId()))
                .toList();
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public void actualizar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}