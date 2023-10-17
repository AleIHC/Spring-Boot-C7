package org.generation.cyberpunk.controllers;


import lombok.AllArgsConstructor;
import org.generation.cyberpunk.DTO.UserDTO;
import org.generation.cyberpunk.models.User;
import org.generation.cyberpunk.services.MyUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private MyUserDetailsService myUserDetailsService;

    private PasswordEncoder passwordEncoder;

    @PostMapping("/registro")
    public ResponseEntity<?> registroUsuario(@RequestBody UserDTO user) {
        System.out.println(user.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user.getPassword());

        UserDTO userResponse = myUserDetailsService.saveUser(user);

        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }



}
