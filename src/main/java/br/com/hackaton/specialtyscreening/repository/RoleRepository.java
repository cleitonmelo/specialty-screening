package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
