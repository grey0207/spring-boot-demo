package demo.controller;

import demo.model.User;
import demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MainController {
    @Autowired
    UserRepository userRepository;
    @GetMapping("/add")
    public String addNewUser (@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "add success";
    }

    @GetMapping("/find")
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/update")
    public String updateUsers(@RequestParam int id, @RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "update success";
    }
}
