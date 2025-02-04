package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.SpecialtyDTO;
import br.com.hackaton.specialtyscreening.service.impl.SpecialtyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/specialty")
public class SpecialtyController {

    private final SpecialtyServiceImpl service;

    @Autowired
    public SpecialtyController(SpecialtyServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> findById(@PathVariable("id") Long id) {
        SpecialtyDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<SpecialtyDTO> create(@RequestBody SpecialtyDTO specialtyDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
            this.service.create(specialtyDTO)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialtyDTO> update(@RequestBody SpecialtyDTO specialtyDTO, @PathVariable("id") Long id)
    {
        SpecialtyDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(this.service.update(id, specialtyDTO));
    }

    @GetMapping
    public ResponseEntity<Page<SpecialtyDTO>> findAll(Pageable pageable) {
         return ResponseEntity.ok().body(this.service.findAll(pageable));
    }
}
