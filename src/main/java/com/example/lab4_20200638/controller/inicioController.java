package com.example.lab4_20200638.controller;


import com.example.lab4_20200638.entity.User;
import com.example.lab4_20200638.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("")
public class inicioController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/**")
    public String handleDefault() {
        return "inicio"; // Nombre de la vista predeterminada
    }

    @GetMapping("/login/inicioSesion")
    public String iniciarSesion(@RequestParam("correo") String correo,
                                @RequestParam("contrasena") String contrasena,
                                Model model) {

        //Optional<User> optionalUser = Optional.ofNullable(userRepository.findUserByEmailAndPassword(correo, contrasena));

        //if (optionalUser.isPresent()) {
        //  User usuario = optionalUser.get();
        // model.addAttribute("usuario", usuario);
        //return "homePage";
        //} else {
        // return "redirect:/";
        //}
        List<User> usuarios = userRepository.findAll();
        String name;
        String passwordd;
        int a = 0;

        for (User u : usuarios) {
            name = u.getEmail();
            passwordd = u.getPassword();
            if ((Objects.equals(name, correo) && Objects.equals(passwordd, contrasena))) {
              a = 1;
              break;
            }else {
                a=0;
            }
        }
        if (a==1){
            return "homePage";
        }else {
            return "redirect:/";
        }
    }
}
