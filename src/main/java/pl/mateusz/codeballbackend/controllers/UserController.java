package pl.mateusz.codeballbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.mateusz.codeballbackend.model.User;
import pl.mateusz.codeballbackend.repositories.UserRepository;

@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 3600L)
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("api/user/me")
    public User getCurrentUser() {
        return new User("ads", "asdaf", "klvf");
    }

    @PostMapping("/api/user")
    public ResponseEntity createUser(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/user")
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/user/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("user doesn't exist"));
    }

    @DeleteMapping("/api/user/{userId}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

    @PutMapping("/api/user/{userId}")
    public ResponseEntity editUser(@RequestBody User user, @PathVariable int userId) {
        user.setId(userId);
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}


