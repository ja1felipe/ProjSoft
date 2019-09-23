package psoft.lab02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import psoft.lab02.entities.user.User;
import psoft.lab02.entities.user.UserDTO;
import psoft.lab02.services.JWTService;
import psoft.lab02.services.UserService;

import javax.servlet.ServletException;
import java.util.Optional;

@RestController
public class UsuarioController {

    private UserService userService;

    public UsuarioController(UserService u){
        this.userService = u;
    }

    @PostMapping("v1/usuarios")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u = userService.addUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
