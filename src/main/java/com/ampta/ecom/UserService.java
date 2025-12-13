package com.ampta.ecom;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>();
    private Long nextId = 1l;

    public List<User> getUsers() {
        return userList;
    }

    public List<User> addUser(User user) {
        user.setId(nextId++);
        userList.add(user);
        return userList;
    }

    public Optional<User> getUserById(Long id) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    public boolean updateUser(Long id, User updateUser) {
        return userList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .map(existingUser -> {
                    existingUser.setFirstName(updateUser.getFirstName());
                    existingUser.setLastName(updateUser.getLastName());
                    return true;
                }).orElse(false);
    }
}
