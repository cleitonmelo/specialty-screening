package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.SpecialistDoctorDTO;
import br.com.hackaton.specialtyscreening.service.SpecialistDoctorService;
import br.com.hackaton.specialtyscreening.service.impl.SpecialistDoctorServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/specialists")
@Tag(name = "Manutenção de Médicos Especialistas",
        description = "API para gerenciamento de médicos especialistas")
public class SpecialistDoctorController {

    private final SpecialistDoctorService service;

    @Autowired
    public SpecialistDoctorController(SpecialistDoctorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecialistDoctorDTO> findById(@PathVariable("id") Long id) {
        SpecialistDoctorDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<SpecialistDoctorDTO> create(@Valid @RequestBody SpecialistDoctorDTO dto){
        if ( ! this.service.isSpecialtyExists(1L) ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(
            this.service.save(dto)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecialistDoctorDTO> update(@Valid @RequestBody SpecialistDoctorDTO specialistDoctorDTO,
                                                      @PathVariable("id") Long id) {
        SpecialistDoctorDTO dto = this.service.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(this.service.update(id, specialistDoctorDTO));
    }

    @GetMapping
    public ResponseEntity<Page<SpecialistDoctorDTO>> findAll(Pageable pageable) {
         return ResponseEntity.ok().body(this.service.findAll(pageable));
    }
}
