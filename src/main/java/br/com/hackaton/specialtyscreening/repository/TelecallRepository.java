package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Telecall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelecallRepository extends JpaRepository<Telecall, Long> {

}
