package br.com.hackaton.specialtyscreening.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.hackaton.specialtyscreening.model.MedicalExam;

@Repository
public interface MedicalExamRepository extends JpaRepository<MedicalExam, Long>{

}
