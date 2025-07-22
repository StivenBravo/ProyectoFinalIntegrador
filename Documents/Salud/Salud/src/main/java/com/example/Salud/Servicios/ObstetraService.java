package com.example.Salud.Servicios;

import com.example.Salud.Entidades.Obstetra;
import com.example.Salud.Entidades.Usuario;
import com.example.Salud.Repositorios.ObstetraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObstetraService {

    @Autowired
    private ObstetraRepository obstetraRepository;

    public Obstetra registrarObstetra(Obstetra obstetra) {
        return obstetraRepository.save(obstetra);
    }

    public List<Obstetra> listarTodos() {
        return obstetraRepository.findAll();
    }

    public List<Obstetra> listarPorEspecialidad(Integer especialidadId) {
        return obstetraRepository.findByEspecialidadId(especialidadId);
    }
    public void guardar(Obstetra obstetra) {
        obstetraRepository.save(obstetra);
    }

    public List<Obstetra> buscarPorDni(String dni) {
        return obstetraRepository.findByUsuarioDni(dni);
    }

    public Obstetra buscarPorUsuario(Usuario usuario) {
        return obstetraRepository.findByUsuario(usuario)
                .orElseThrow(() -> new IllegalStateException("Obstetra no encontrado para el usuario"));
    }
}
