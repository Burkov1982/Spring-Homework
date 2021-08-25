package com.spring.service;

import com.spring.dao.UserRepository;
import com.spring.dao.model.User;
import com.spring.dao.model.enums.UserRole;
import com.spring.dao.model.enums.UserStatus;
import com.spring.exceptions.EmailNotValidException;
import com.spring.exceptions.UserAlreadyExistException;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void register(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistException(String.format("User with specified email already exist %s", user.getEmail()));
        }
        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new EmailNotValidException(String.format("Specified email %s not valid", user.getEmail()));
        }
        user.setUserRole(UserRole.ROLE_USER.getRole());
        user.setPassword(encoder.encode(user.getPassword()));
        user.setUserStatus(UserStatus.ACTIVE);
        userRepository.save(user);
    }

    public void update(User user) {
        if (userRepository.findByEmail(user.getEmail()).isEmpty()) {
            throw  new UsernameNotFoundException("User with specified email not found");
        }
        if (!EmailValidator.getInstance().isValid(user.getEmail())) {
            throw new EmailNotValidException(String.format("Specified email %s not valid", user.getEmail()));
        }
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isPresent()){
            return user.get();
        } else {
            throw  new UsernameNotFoundException("User with specified email not found");
        }
    }

    private boolean checkIsLastAdmin(User user) {
        boolean result = false;
        if (user.getUserRole().equals(UserRole.ROLE_ADMIN.getRole())) {
            List<User> users = userRepository.findByUserRole(UserRole.ROLE_ADMIN);
            if (users.size()==1) {
                result = user.equals(users.get(0));
                return result;
            }
        }
        return result;
    }

    public void delete(User user) {
        if (!checkIsLastAdmin(user)){
            userRepository.delete(user);
        }
    }

    public User findById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        if (user.isPresent()){
            return user.get();
        } else {
            throw  new UsernameNotFoundException("User with specified id not found");
        }
    }
}