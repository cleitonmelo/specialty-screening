package br.com.hackaton.specialtyscreening.repository;

import br.com.hackaton.specialtyscreening.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    UserDetails findByUserName(String userName);
}
