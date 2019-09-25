package psoft.lab02.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import psoft.lab02.entities.user.User;
import psoft.lab02.services.JWTService;
import psoft.lab02.services.UserService;

import javax.servlet.ServletException;
import java.util.Optional;

@RestController
public class LoginController {

    private final String TOKEN_KEY = "chama no baxara lazap";

    private UserService userService;
    private JWTService jwtService;

    public LoginController(UserService usuariosService, JWTService jwtService) {
        super();
        this.userService = usuariosService;
        this.jwtService = jwtService;
    }

    @PostMapping("v1/auth/login")
    public LoginResponse authenticate(@RequestBody User usuario) throws ServletException {

        // Recupera o usuario
        Optional<User> authUsuario = userService.getUser(usuario.getEmail());

        // verificacoes
        if (!authUsuario.isPresent()) {
            throw new ServletException("Usuario nao encontrado!");
        }

        verificaSenha(usuario, authUsuario);

        String token = jwtService.geraToken(authUsuario.get().getEmail());

        return new LoginResponse(token);

    }

    private void verificaSenha(User usuario, Optional<User> authUsuario) throws ServletException {
        if (!authUsuario.get().getPassword().equals(usuario.getPassword())) {
            throw new ServletException("Senha invalida!");
        }
    }

    public class LoginResponse{
        public String token;

        public LoginResponse(String token){
            this.token = token;
        }
    }

}
