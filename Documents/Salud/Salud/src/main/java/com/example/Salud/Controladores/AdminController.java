package com.example.Salud.Controladores;

import com.example.Salud.Entidades.Usuario;
import com.example.Salud.Servicios.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/panel")
    public String panelAdmin(HttpSession session, Model model) {
        Usuario admin = (Usuario) session.getAttribute("usuarioLogueado");
        if (admin == null || !"ADMIN".equals(admin.getRol().getNombre())) {
            return "redirect:/login";
        }

        List<Usuario> jefas = usuarioService.listarPorRol("JEFA");
        model.addAttribute("jefas", jefas);
        return "admin/panel";
    }

    @GetMapping("/registrar-jefa")
    public String formJefa(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "admin/registrar-jefa";
    }

    @PostMapping("/registrar-jefa")
    public String registrarJefa(@ModelAttribute Usuario usuario) {
        usuarioService.registrarUsuario(usuario, "JEFA");
        return "redirect:/admin/panel";
    }
}