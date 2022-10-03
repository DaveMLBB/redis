package co.develhope.redis.controllers;

import co.develhope.redis.entities.User;
import co.develhope.redis.entities.UserJPA;
import co.develhope.redis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserJPA create(@RequestBody UserJPA user){
        return userService.create(user);

    }

    @GetMapping()
    public List<UserJPA> readAll(){
        return userService.readAll();

    }

    @GetMapping("/{id}")
    public void readOne(@PathVariable Long id){
        userService.readOne(id);

    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UserJPA user){
        userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);

    }
}
