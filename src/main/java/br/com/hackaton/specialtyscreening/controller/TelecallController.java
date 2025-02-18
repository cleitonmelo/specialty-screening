package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.TelecallDTO;
import br.com.hackaton.specialtyscreening.service.impl.TelecallServiceImpl;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/telecall")
@Tag(name = "Lista das teleatendimentos",
        description = "API para listar os possíveis status para utilização no sistema")
public class TelecallController {

    private final TelecallServiceImpl telecallService;

    public TelecallController(TelecallServiceImpl telecallService) {
        this.telecallService = telecallService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TelecallDTO> findById(@PathVariable Long id) {
        TelecallDTO telecallDTO = this.telecallService.findById(id);
        if( telecallDTO != null){
            return ResponseEntity.ok().body(telecallDTO);

        }
        return ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<TelecallDTO> create(@RequestBody TelecallDTO telecallDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(this.telecallService.save(telecallDTO));
    }
    @PutMapping("/{id}")
    public ResponseEntity<TelecallDTO> update(@PathVariable Long id, @RequestBody TelecallDTO telecallDTO) {
        TelecallDTO telecallDTO1 = this.telecallService.findById(id);
        if( telecallDTO1 != null){
            return ResponseEntity.ok().body(this.telecallService.update(id, telecallDTO));
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping
    public ResponseEntity<Page<TelecallDTO>> findAll(
            @ParameterObject
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC)
            Pageable pageable) {
        return ResponseEntity.ok().body(this.telecallService.findAll(pageable));
    }
}
