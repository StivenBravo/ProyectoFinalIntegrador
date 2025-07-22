package com.example.Salud.Controladores;

import com.example.Salud.Entidades.Obstetra;
import com.example.Salud.Entidades.Paciente;
import com.example.Salud.Entidades.Usuario;
import com.example.Salud.Servicios.AtencionService;
import com.example.Salud.Servicios.EspecialidadService;
import com.example.Salud.Servicios.ObstetraService;
import com.example.Salud.Servicios.PacienteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/obstetra")
public class ObstetraController {

    @Autowired
    private EspecialidadService especialidadService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private AtencionService atencionService;
    @Autowired
    private ObstetraService obstetraService; // ✅ instancia inyectada correctamente

    @GetMapping("/panel")
    public String panelObstetra(HttpSession session, Model model) {
        Usuario obstetraUser = (Usuario) session.getAttribute("usuarioLogueado");
        if (obstetraUser == null || !"OBSTETRA".equals(obstetraUser.getRol().getNombre())) {
            return "redirect:/login";
        }

        Obstetra obstetra = obstetraService.buscarPorUsuario(obstetraUser);
        model.addAttribute("pacientes", pacienteService.listarPorObstetra(obstetra.getId()));
        return "obstetra/panel";
    }


    @GetMapping("/registrar-paciente")
    public String formPaciente(Model model) {
        model.addAttribute("paciente", new Paciente());
        model.addAttribute("especialidades", especialidadService.listarTodas());
        return "obstetra/registrar-paciente";
    }

    @PostMapping("/registrar-paciente")
    public String registrarPaciente(@ModelAttribute Paciente paciente, HttpSession session) {
        Usuario obstetraUser = (Usuario) session.getAttribute("usuarioLogueado");

        // ✅ Llamada correcta al servicio
        Obstetra obstetra = obstetraService.buscarPorUsuario(obstetraUser);

        paciente.setObstetra(obstetra); // Asignación obligatoria
        pacienteService.registrarPaciente(paciente);

        return "redirect:/obstetra/panel";
    }
}
