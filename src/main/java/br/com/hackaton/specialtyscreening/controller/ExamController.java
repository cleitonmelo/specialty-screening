package br.com.hackaton.specialtyscreening.controller;

import br.com.hackaton.specialtyscreening.dto.ExamDTORequest;
import br.com.hackaton.specialtyscreening.model.Exam;
import br.com.hackaton.specialtyscreening.service.ExamService;
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
public class ExamController {

    @Autowired
    private ExamService examService;

    @PostMapping
    public ResponseEntity<Exam> createExam(@RequestBody ExamDTORequest examDTORequest){
        Exam exam = examService.create(examDTORequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(exam);
    }

    @GetMapping
    public ResponseEntity<Page<Exam>> getAllExam(@PageableDefault(page = 0, size = 10) Pageable pageable) {
        Page<Exam> examsPage =  examService.findAll(pageable);
        return ResponseEntity.ok(examsPage);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneExam(@PathVariable("id") Long id) {
        Optional<Exam> examOptional = examService.findById(id);
        if(examOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(examOptional.get());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateExam(@PathVariable("id") Long id, @RequestBody ExamDTORequest examDTORequest)
    {
        Optional<Exam> examOptional = examService.update(id, examDTORequest);
        if(examOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Exam not found");
        } else {
            return ResponseEntity.ok(examOptional.get());
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
