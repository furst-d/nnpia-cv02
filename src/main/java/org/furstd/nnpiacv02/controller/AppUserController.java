package org.furstd.nnpiacv02.controller;

import jakarta.validation.Valid;
import org.furstd.nnpiacv02.dto.AppUserDTO;
import org.furstd.nnpiacv02.dto.AuthenticationResponseDTO;
import org.furstd.nnpiacv02.entity.AppUser;
import org.furstd.nnpiacv02.exceptions.NotFoundException;
import org.furstd.nnpiacv02.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("app-user")
@RestController
public class AppUserController {
    private final IAppUserService appUserService;

    @Autowired
    public AppUserController(IAppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @RequestMapping("{id}")
    public AppUser getUser(@PathVariable int id) {
        return appUserService.findUser(id)
                .orElseThrow(() -> new NotFoundException("User with ID " + id + " not found"));
    }

    @PostMapping("register")
    public ResponseEntity<String> createUser(@Valid @RequestBody AppUserDTO userDTO) {
        AppUser appUser = new AppUser(userDTO.getUsername(), userDTO.getPassword());
        appUserService.createUser(appUser);
        return ResponseEntity.status(HttpStatus.CREATED).body("User was created successfully!");
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponseDTO> login(@Valid @RequestBody AppUserDTO userDTO) {
        return ResponseEntity.ok(appUserService.login(userDTO));
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id, @RequestBody AppUserDTO userDTO) {
        AppUser user = appUserService.findUser(id)
                .orElseThrow(() -> new NotFoundException("User with ID " + id + " not found"));

        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        appUserService.updateUser(user);

        return ResponseEntity.ok("User was updated successfully!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable int id) {
        AppUser user = appUserService.findUser(id)
                .orElseThrow(() -> new NotFoundException("User with ID " + id + " not found"));

        appUserService.deleteUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User was deleted successfully!");
    }
}
