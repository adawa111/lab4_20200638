package com.example.lab4_20200638.controller;


import com.example.lab4_20200638.entity.Reserva;
import com.example.lab4_20200638.entity.User;
import com.example.lab4_20200638.entity.Vuelo;
import com.example.lab4_20200638.repository.ReservaRepository;
import com.example.lab4_20200638.repository.UserRepository;
import com.example.lab4_20200638.repository.VueloRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("")
public class inicioController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    ReservaRepository reservaRepository;

    @GetMapping("/**")
    public String handleDefault() {
        return "inicio"; // Nombre de la vista predeterminada
    }

    @PostMapping("/confirmarReserva")
    public String confirmarReserva(@RequestParam("idVuelo") int idVuelo,
                                 @RequestParam("idUser") int idUser,
                                 RedirectAttributes attr) {
        // Código para confirmar la reserva del producto con el ID especificado
        Vuelo vuelo = vueloRepository.findVueloByIdvuelo(idVuelo);
        System.out.println("guardadooooooo");
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String fecha = fechaHoraActual.format(formato);
        reservaRepository.guardarReserva(fecha,  vuelo.getPrecio(), "Procesado" , idUser, vuelo.getIdvuelo() );
        attr.addFlashAttribute("alert","mostrar");
        return "redirect:/homePage";

    }

    @GetMapping("/homePage")
    public String homePage(
                                Model model,
                           HttpSession session) {
        String idusuario= (String) session.getAttribute("iduser");
        List<Vuelo> listaVuelos = vueloRepository.findAll();
        model.addAttribute("listaVuelos",listaVuelos);
        int iduser = Integer.parseInt(idusuario);
        model.addAttribute("iduser",iduser);
        return "homePage";
    }


    @PostMapping("/login/inicioSesion")
    public String iniciarSesion(@RequestParam("correo") String correo,
                                @RequestParam("contrasena") String contrasena,
                                HttpSession session,
                                Model model) {
        List<User> usuarios = userRepository.findAll();
        String name;
        String passwordd;
        int a = 0;
        int iduser = 0;

        for (User u : usuarios) {
            name = u.getEmail();
            passwordd = u.getPassword();
            if ((Objects.equals(name, correo) && Objects.equals(passwordd, contrasena))) {
              a = 1;
              iduser = u.getId();
              break;
            }else {
                a=0;
            }
        }
        if (a==1){
            String idusario = String.valueOf(iduser);
            session.setAttribute("iduser", idusario);
            return "redirect:/homePage";
        }else {
            return "redirect:/";
        }
    }
}
