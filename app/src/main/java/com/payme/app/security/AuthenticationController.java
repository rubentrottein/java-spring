package com.payme.app.security;

import com.payme.app.model.User;
import com.payme.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "authentication/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user, Model model) {
        try {
            System.out.println("Trying to register user: " + user);
            userService.registerNewUserAccount(user);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Une erreur s'est produite lors de l'enregistrement. Veuillez réessayer.");
            return "authentication/register";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {
        try {
            if (error != null) {
                model.addAttribute("errorMessage", "Nom d'utilisateur ou mot de passe incorrect.");
            }
            if (userService.getCurrentUser() != null) {
                model.addAttribute("errorMessage", "Utilisateur connecté");
            }
            System.out.println("On se connecte en temps que: " + userService.getCurrentUser().getName());
            return "redirect:/profile";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "authentication/login";
        }
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("msg", "Déconnexion");
        model.addAttribute("trace", "Vous avez été déconnecté");
        return "confirmation";
    }
}
