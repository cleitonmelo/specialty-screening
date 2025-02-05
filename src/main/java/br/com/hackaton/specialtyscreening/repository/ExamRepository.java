package br.com.hackaton.specialtyscreening.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.hackaton.specialtyscreening.model.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long>{
    @Modifying
    @Query("UPDATE Exam e SET e.resultado = :novoResultado WHERE e.status = 'PENDENTE'")
    void updateResultExams();
}
