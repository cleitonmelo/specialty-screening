package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.UserDto;
import br.com.hackaton.specialtyscreening.model.Users;
import br.com.hackaton.specialtyscreening.repository.UserRepository;
import br.com.hackaton.specialtyscreening.security.jwt.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public AuthController(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDto userDto) {
        return jwtUtil.generateToken(userDto.email());
    }

    @PostMapping("/users")
    public ResponseEntity<Users> create(@RequestBody UserDto userDto) {
        Users user = Users.builder().userName(userDto.email()).password("123456").build();
        Users userCreated = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }
}

