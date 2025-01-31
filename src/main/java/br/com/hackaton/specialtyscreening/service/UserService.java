package br.com.hackaton.specialtyscreening.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDetails findUserByUserName(String userName);
}
