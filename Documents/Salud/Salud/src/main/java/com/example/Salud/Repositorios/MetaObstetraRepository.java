
package com.example.Salud.Repositorios;

import com.example.Salud.Entidades.MetaObstetra;
import com.example.Salud.Entidades.Obstetra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MetaObstetraRepository extends JpaRepository<MetaObstetra, Integer> {
    Optional<MetaObstetra> findByObstetraAndAnio(Obstetra obstetra, int anio);
}
