package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.service.impl.ScreeningServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> findById(@PathVariable("id") String id) {
        var data = screeningService.get(id);
        return ResponseEntity.ok().body(data.toLowerCase());
    }

    @PostMapping
    public ResponseEntity<String> create(){
        return ResponseEntity.ok().body(this.screeningService.create());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update()
    {
        return ResponseEntity.ok().body(this.screeningService.update());
    }
}
