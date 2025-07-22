package com.example.Salud.Controladores;

import com.example.Salud.Entidades.Obstetra;
import com.example.Salud.Entidades.Usuario;
import com.example.Salud.Servicios.EspecialidadService;
import com.example.Salud.Servicios.ObstetraService;
import com.example.Salud.Servicios.PacienteService;
import com.example.Salud.Servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jefa")
public class JefaController {

    @Autowired
    private ObstetraService obstetraService;

    @Autowired
    private EspecialidadService especialidadService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/panel")
    public String panelJefa(HttpSession session, Model model) {
        Usuario jefa = (Usuario) session.getAttribute("usuarioLogueado");
        if (jefa == null || !"JEFA".equals(jefa.getRol().getNombre())) {
            return "redirect:/login";
        }

        model.addAttribute("obstetras", obstetraService.listarTodos());
        return "jefa/panel";
    }

    @GetMapping("/registrar-obstetra")
    public String formObstetra(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("especialidades", especialidadService.listarTodas());
        return "jefa/registrar-obstetra";
    }

    @PostMapping("/registrar-obstetra")
    public String registrarObstetra(@ModelAttribute Usuario usuario,
                                    @RequestParam Long especialidadId,
                                    Model model) {
        try {
            // Registrar usuario con rol OBSTETRA
            Usuario usuarioGuardado = usuarioService.registrarUsuario(usuario, "OBSTETRA");

            // Crear obstetra y asociar especialidad
            Obstetra obstetra = new Obstetra();
            obstetra.setUsuario(usuarioGuardado);
            obstetra.setEspecialidad(especialidadService.buscarPorId(especialidadId));
            obstetraService.guardar(obstetra);

            return "redirect:/jefa/panel";

        } catch (IllegalStateException e) {
            // Mostrar error en la vista si el DNI o username ya existen
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuario", usuario);
            model.addAttribute("especialidades", especialidadService.listarTodas());
            return "jefa/registrar-obstetra";
        }
    }
}