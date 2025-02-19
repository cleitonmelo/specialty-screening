package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.controller.resources.ScreeningResource;
import br.com.hackaton.specialtyscreening.model.Screening;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    Page<Screening> findBySpecialtyId(Long specialtyId, Pageable pageable);

    @Query(countQuery = "SELECT DISTINCT * FROM screening s WHERE s.status :screeningStatus", nativeQuery = true)
    ScreeningResource findAllbyScreeningStatus(Long screeningStatus);
}
