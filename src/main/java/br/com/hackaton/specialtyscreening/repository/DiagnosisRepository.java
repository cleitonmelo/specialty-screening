package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Diagnosis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiagnosisRepository extends JpaRepository<Diagnosis, Long> {

}
