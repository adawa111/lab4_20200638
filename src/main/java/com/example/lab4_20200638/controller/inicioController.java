package com.example.lab4_20200638.controller;
import com.twilio.jwt.accesstoken.AccessToken;
import com.twilio.jwt.accesstoken.VideoGrant;


import com.example.lab4_20200638.entity.Reserva;
import com.example.lab4_20200638.entity.User;
import com.example.lab4_20200638.entity.Vuelo;
import com.example.lab4_20200638.repository.ReservaRepository;
import com.example.lab4_20200638.repository.UserRepository;
import com.example.lab4_20200638.repository.VueloRepository;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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

    @GetMapping("/videollamada")
    public String videoCall(Model model) {
        // Lógica para obtener los datos necesarios (por ejemplo, participantes, ID de la sala) y pasarlos al modelo

        // Pasa los datos necesarios al modelo
        model.addAttribute("roomName", "room123");
        model.addAttribute("accessToken", generateAccessToken("room123"));

        // Retorna la plantilla Thymeleaf que renderizará la página de videollamada
        return "video";
    }

    private String generateAccessToken(String roomName) {
        String accountSid = "AC96db5fc6a2f8801627e8b0c896f12cbc";
        String apiKey = "SKf5c61962530c91fff1872f1693377e85";
        String apiSecret = "VgxmTGy2DGrnbiDSi0ExJ7GJ4MmAFTdA";

        // Define el tiempo de expiración del token (1 hora en este ejemplo)
        Date expirationDate = new Date(System.currentTimeMillis() + 3600000);

        // Crea un mapa para los claims (datos adicionales) del token
        Map<String, Object> claims = new HashMap<>();
        claims.put("room", roomName);

        // Crea el token JWT
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuer(apiKey)
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256, apiSecret.getBytes());

        // Devuelve el token en forma de cadena
        return jwtBuilder.compact();
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
