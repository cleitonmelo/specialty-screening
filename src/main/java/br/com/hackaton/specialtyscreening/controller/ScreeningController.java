package br.com.hackaton.specialtyscreening.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/screening")
public class ScreeningController {

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok().body("Detalhe da triagem: " + id);
    }

    @PostMapping
    public ResponseEntity<String> create(){
        return ResponseEntity.ok().body("Formulário de triagem criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update()
    {
        return ResponseEntity.ok().body("Formulário atualizado com sucesso");
    }
}
