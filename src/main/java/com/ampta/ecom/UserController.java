package com.ampta.ecom;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> createUsers(@RequestBody User user) {
     userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateUsers(@PathVariable Long id, @RequestBody User updateUser) {
        boolean updated = userService.updateUser(id, updateUser);
        if(updated)
            return ResponseEntity.ok("User updated successfully");

        return ResponseEntity.notFound().build();
    }
}
