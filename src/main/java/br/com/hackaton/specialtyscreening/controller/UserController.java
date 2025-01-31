package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.LoginDto;
import br.com.hackaton.specialtyscreening.model.Users;
import br.com.hackaton.specialtyscreening.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody LoginDto userDto) {
        Users user = Users.builder()
                .userName(userDto.email())
                .password(userDto.password())
                .build();

        Users userCreated = userService.saveUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> get(@PathVariable Long id) {
        Users user = userService.getById(id);
        return ResponseEntity.ok(user);
    }
}
