package com.spring.service;

import com.spring.config.converters.UserConverter;
import com.spring.dao.UserRepository;
import com.spring.dao.model.User;
import com.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userConverter::fromUser)
                .collect(Collectors.toList());
    }

    public UserDTO findById(UUID uuid) {
        Optional<User> user = userRepository.findById(uuid);
        return user.map(userConverter::fromUser)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void saveOrUpdate(UserDTO userDTO) {
        User user = userConverter.toUser(userDTO);
        userRepository.save(user);
    }

    public void delete (UserDTO userDTO) {
        User user = userConverter.toUser(userDTO);
        userRepository.delete(user);
    }
}
