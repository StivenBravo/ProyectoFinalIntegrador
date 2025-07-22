package com.example.Salud.Repositorios;
import com.example.Salud.Entidades.Atencion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AtencionRepository extends JpaRepository<Atencion, Integer> {
    List<Atencion> findByObstetraIdAndFechaBetween(Integer obstetraId, LocalDate inicio, LocalDate fin);
    List<Atencion> findByPacienteDni(String dni);
}