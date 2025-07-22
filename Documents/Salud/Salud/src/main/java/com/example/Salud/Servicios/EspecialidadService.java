package com.example.Salud.Servicios;

import com.example.Salud.Entidades.Especialidad;
import com.example.Salud.Repositorios.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadService {

    @Autowired
    private EspecialidadRepository especialidadRepository;

    public List<Especialidad> listarTodas() {
        return especialidadRepository.findAll();
    }

    public Especialidad registrar(String nombre) {
        Especialidad e = new Especialidad();
        e.setNombre(nombre);
        return especialidadRepository.save(e);
    }
    public Especialidad buscarPorId(Long id) {
        return especialidadRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new IllegalStateException("Especialidad no encontrada"));
    }
}