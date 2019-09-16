package psoft.lab02.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import psoft.lab02.entities.user.User;
import psoft.lab02.services.UserService;

@RestController
public class UsuarioController {

    @Autowired
    private UserService userService;

    @PostMapping("v1/auth/usuarios")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User u = userService.addUser(user);
        return new ResponseEntity<>(u, HttpStatus.OK);
    }
}
