package com.example.Salud.Repositorios;
import com.example.Salud.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PacienteRepository extends JpaRepository<Paciente, Integer> {
    List<Paciente> findByObstetraId(Integer obstetraId);
    List<Paciente> findByObstetraIdAndFechaRegistroBetween(Integer obstetraId, LocalDate inicio, LocalDate fin);
}