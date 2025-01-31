package br.com.hackaton.specialtyscreening.service;

import br.com.hackaton.specialtyscreening.model.Users;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails findUserByUserName(String userName);

    Users getUserByUserName(String userName);

    String setToken(String email);

    Users saveUser(Users user);

    Users getById(Long id);
}
