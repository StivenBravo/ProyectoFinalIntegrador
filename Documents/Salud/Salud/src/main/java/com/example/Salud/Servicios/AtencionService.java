package com.example.Salud.Servicios;

import com.example.Salud.Entidades.Atencion;
import com.example.Salud.Repositorios.AtencionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtencionService {

    @Autowired
    private AtencionRepository atencionRepository;

    public Atencion registrarAtencion(Atencion atencion) {
        atencion.setFecha(LocalDate.now());
        return atencionRepository.save(atencion);
    }

    public List<Atencion> listarPorObstetraEnMes(Integer obstetraId, LocalDate inicio, LocalDate fin) {
        return atencionRepository.findByObstetraIdAndFechaBetween(obstetraId, inicio, fin);
    }

    public List<Atencion> listarPorDniPaciente(String dni) {
        return atencionRepository.findByPacienteDni(dni);
    }
}