package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.LoginDto;
import br.com.hackaton.specialtyscreening.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService service) {
        this.userService = service;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto userDto) {
        String token = userService.setToken(userDto.email());
        return ResponseEntity.ok().body(token);
    }


}

