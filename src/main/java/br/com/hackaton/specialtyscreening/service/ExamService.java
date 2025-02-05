package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    @Autowired
    private ExamRepository examRepository;

    public void updateResultExams() {
        examRepository.updateResultExams();
    }
}
