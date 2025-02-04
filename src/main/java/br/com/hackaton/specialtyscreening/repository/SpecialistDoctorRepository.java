package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.SpecialistDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistDoctorRepository extends JpaRepository<SpecialistDoctor, Long> {
}
