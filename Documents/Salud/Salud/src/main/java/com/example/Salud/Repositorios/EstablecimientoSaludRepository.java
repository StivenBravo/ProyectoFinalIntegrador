
package com.example.Salud.Repositorios;

import com.example.Salud.Entidades.EstablecimientoSalud;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EstablecimientoSaludRepository extends JpaRepository<EstablecimientoSalud, Integer> {
    Optional<EstablecimientoSalud> findByCodigoRenace(String codigoRenace);
}
