package br.com.hackaton.specialtyscreening.service.impl;

import br.com.hackaton.specialtyscreening.model.Users;
import br.com.hackaton.specialtyscreening.repository.UserRepository;
import br.com.hackaton.specialtyscreening.security.jwt.JwtUtil;
import br.com.hackaton.specialtyscreening.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Autowired
    private UserServiceImpl(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public UserDetails findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Users getUserByUserName(String userName) {
        return userRepository.getByUserName(userName);
    }

    @Override
    public String setToken(String email) {
        Users user = userRepository.getByUserName(email);
        String token = jwtUtil.generateToken(email);
        if ( user != null ){
            user.setToken(token);
            userRepository.save(user);
        }
        return token;
    }

    @Override
    public Users saveUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getById(Long id) {
        final Users users = userRepository.findById(id).get();
        return users;
    }
}
