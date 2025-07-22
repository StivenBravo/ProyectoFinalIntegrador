package com.example.Salud.Servicios;

import com.example.Salud.Entidades.Paciente;
import com.example.Salud.Repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente registrarPaciente(Paciente paciente) {
        paciente.setFechaRegistro(LocalDate.now());
        return pacienteRepository.save(paciente);
    }

    public List<Paciente> listarPorObstetra(Integer obstetraId) {
        return pacienteRepository.findByObstetraId(obstetraId);
    }

    public List<Paciente> listarPorObstetraEnMes(Integer obstetraId, LocalDate inicio, LocalDate fin) {
        return pacienteRepository.findByObstetraIdAndFechaRegistroBetween(obstetraId, inicio, fin);
    }

}