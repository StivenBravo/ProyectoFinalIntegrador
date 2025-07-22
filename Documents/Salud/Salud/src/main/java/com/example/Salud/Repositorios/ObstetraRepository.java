package com.example.Salud.Repositorios;

import com.example.Salud.Entidades.Obstetra;
import com.example.Salud.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ObstetraRepository extends JpaRepository<Obstetra, Integer> {
    List<Obstetra> findByEspecialidadId(Integer especialidadId);
    List<Obstetra> findByUsuarioDni(String dni);

    // ✅ Añade esta línea si no la tienes
    Optional<Obstetra> findByUsuario(Usuario usuario);
}
