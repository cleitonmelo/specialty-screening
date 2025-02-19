package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.ExamDTO;
import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import br.com.hackaton.specialtyscreening.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/exam")
@RequiredArgsConstructor
public class ExamController {

    @Autowired
    private final ExamService examService;

    @PostMapping
    public ResponseEntity<ExamDTO> createExam(@RequestBody ExamDTORequest examDTORequest){
        ExamDTO examDto = examService.create(examDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(examDto);
    }

    @GetMapping
    public ResponseEntity<Page<ExamDTO>> getAllExam(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<ExamDTO> examsDtoPage =  examService.findAll(pageable);
        return ResponseEntity.ok(examsDtoPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneExam(@PathVariable("id") Long id) {
        Optional<ExamDTO> examDtoOptional = examService.findById(id);
        if(examDtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(examDtoOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExam(@PathVariable("id") Long id, @RequestBody ExamDTORequest examDTORequest)
    {
        Optional<ExamDTO> examDtoOptional = examService.update(id, examDTORequest);
        if(examDtoOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found");
        } else {
            return ResponseEntity.ok(examDtoOptional.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteExamById(@PathVariable("id") Long id)
    {
        boolean deleted = examService.deleteById(id);
        if(!deleted){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Exam deleted successfully");
        }
    }
}
