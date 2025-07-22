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

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String mostrarLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }
    @GetMapping("/cerrar-sesion")
    public String cerrarSesion(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String procesarLogin(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        Optional<Usuario> usuarioOpt = usuarioService.buscarPorUsername(usuario.getUsername());

        if (usuarioOpt.isPresent()) {
            Usuario u = usuarioOpt.get();

            if (u.getPassword().equals(usuario.getPassword())) {
                // Login exitoso: reiniciar contador
                u.setIntentosFallidos(0);
                usuarioService.actualizar(u);
                session.setAttribute("usuarioLogueado", u);

                switch (u.getRol().getNombre()) {
                    case "ADMIN": return "redirect:/admin/panel";
                    case "JEFA": return "redirect:/jefa/panel";
                    case "OBSTETRA": return "redirect:/obstetra/panel";
                }
            } else {
                // Contraseña incorrecta: incrementar contador
                int nuevosIntentos = u.getIntentosFallidos() + 1;
                u.setIntentosFallidos(nuevosIntentos);
                usuarioService.actualizar(u);

                model.addAttribute("error", "Contraseña incorrecta. Intentos fallidos: " + nuevosIntentos);
                return "login";
            }
        }

        model.addAttribute("error", "Usuario no encontrado");
        return "login";
    }


}