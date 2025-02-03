package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {
}
