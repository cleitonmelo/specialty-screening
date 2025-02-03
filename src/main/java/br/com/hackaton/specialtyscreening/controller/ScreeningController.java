package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.mappers.ScreeningMapper;
import br.com.hackaton.specialtyscreening.service.impl.ScreeningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/screening")
public class ScreeningController {

    private final ScreeningServiceImpl screeningService;

    @Autowired
    public ScreeningController(ScreeningServiceImpl screeningService) {
        this.screeningService = screeningService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScreeningResource> findById(@PathVariable("id") Long id) {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(ScreeningMapper.toResource(screeningService.get(id)));
    }

    @PostMapping
    public ResponseEntity<ScreeningResource> create(@RequestBody ScreeningDTO screeningDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                ScreeningMapper.toResource(
                    this.screeningService.create(screeningDTO)
            )
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScreeningResource> update(@RequestBody ScreeningDTO screeningDTO, @PathVariable("id") Long id)
    {
        ScreeningDTO dto = this.screeningService.get(id);
        if ( dto == null ) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(
                ScreeningMapper.toResource(
                        this.screeningService.update(screeningDTO)
                )
        );
    }
}
