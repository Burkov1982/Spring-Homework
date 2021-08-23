package com.spring.config.converters;

import com.spring.dao.model.User;
import com.spring.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    public User toUser(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getUser_email(), userDTO.getUser_password(),
                userDTO.getFirstname(), userDTO.getLastname(), userDTO.getUser_role());
    }

    public UserDTO fromUser(User user) {
        return new UserDTO(user.getId(), user.getUser_email(), user.getUser_password(),
                user.getFirstname(), user.getLastname(), user.getUser_role().toString());
    }
}
