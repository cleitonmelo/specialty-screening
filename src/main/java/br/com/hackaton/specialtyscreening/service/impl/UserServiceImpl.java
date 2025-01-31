package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.model.Users;
import br.com.hackaton.specialtyscreening.repository.UserRepository;
import br.com.hackaton.specialtyscreening.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    private UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
