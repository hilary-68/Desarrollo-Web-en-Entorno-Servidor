package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Controlador {
	
	@GetMapping("/")
    public String raizWeb(HttpSession session, Model model) {
        
		Usuario usuario = (Usuario) session.getAttribute("usuario");
	    if (usuario == null) {
	        return "redirect:/login";
	    }
	    model.addAttribute("usuario", usuario);
	    model.addAttribute("paginaActual", "Inicio");
	    return "pagina";
    }

    @GetMapping("/pagina1")
    public String pagina1(HttpSession session, Model model) {
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("paginaActual", "Pagina1");
        return "pagina";
    }

    @GetMapping("/pagina2")
    public String pagina2(HttpSession session, Model model) {
    	
    	Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/login";
        }
        model.addAttribute("usuario", usuario);
        model.addAttribute("paginaActual", "Pagina2");
        return "pagina";
    }

    @GetMapping("/login")
    public String verLogin(HttpSession session, Model model) {
        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario != null) {
            return "redirect:/";
        }

        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute Usuario usuario, HttpSession session, Model model) {
        
        if (usuario.getNombre() != null && usuario.getContraseña() != null
                && usuario.getNombre().trim().equals("usuario")
                && usuario.getContraseña().equals("1234")) {
            usuario.setNombre(usuario.getNombre().trim());
            session.setAttribute("usuario", usuario);
            return "redirect:/";
        }

        model.addAttribute("error", "Usuario o Contraseña incorrectos");
        usuario.setContraseña(""); 
        model.addAttribute("usuario", usuario);
        return "login";
    }
	
	
	
}