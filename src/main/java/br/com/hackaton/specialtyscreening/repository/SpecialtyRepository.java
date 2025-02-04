package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
