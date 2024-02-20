package org.furstd.nnpiacv02.controller;

import org.furstd.nnpiacv02.model.User;
import org.furstd.nnpiacv02.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RequestMapping("users")
@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;

        this.userService.createUser(new User(1, "John", "Doe", 25));
        this.userService.createUser(new User(2, "Jane", "Doe", 22));
        this.userService.createUser(new User(3, "John", "Smith", 30));
    }

    @RequestMapping("")
    public Collection<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }
}
