package com.example.Salud.Repositorios;
import com.example.Salud.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByDni(String dni);
    Optional<Usuario> findByUsername(String username);

}