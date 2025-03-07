package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.DiagnosisStatusDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningDTO;
import br.com.hackaton.specialtyscreening.dto.ScreeningStatusDTO;
import br.com.hackaton.specialtyscreening.enums.DiagnosisStatus;
import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/status")
@Tag(name = "Lista dos Status",
        description = "API para listar os possíveis status para utilização no sistema")
public class StatusController extends BaseController {

    @GetMapping("/diagnosis")
    public ResponseEntity<List<DiagnosisStatusDTO>> findAll() {
        List<DiagnosisStatusDTO> statusList = Arrays.stream(DiagnosisStatus.values())
                        .map(status -> DiagnosisStatusDTO.builder()
                                .id(status.name())
                                .name(status.getStatus())
                                .meaning(status.getDescription()).build()).toList();
        return ResponseEntity.ok(statusList);
    }

    @GetMapping("/screenings")
    public ResponseEntity<List<ScreeningStatusDTO>> findAllScreenings() {
        List<ScreeningStatusDTO> statusList = Arrays.stream(ScreeningStatus.values())
                .map(status -> ScreeningStatusDTO.builder()
                        .id(String.valueOf(status.getCode()))
                        .description(status.getDescription()).build()).toList();
        return ResponseEntity.ok(statusList);
    }
}
