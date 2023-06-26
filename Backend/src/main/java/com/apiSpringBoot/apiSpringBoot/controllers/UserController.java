package com.apiSpringBoot.apiSpringBoot.controllers;

import com.apiSpringBoot.apiSpringBoot.models.User;
import com.apiSpringBoot.apiSpringBoot.services.UserService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<Page<User>> findAllUsers(Pageable pageable){
        Page<User> result = userService.findAllUsers(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("filter")
    public ResponseEntity<Page<User>> findAllUsersByFilter(@RequestParam(defaultValue = "") String filter, Pageable pageable){
        Page<User> result = userService.findAllUsersByFilter(filter, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("filterAnd")
    //Retorna todos os usuários que possuem o prefixo em comum com o nome completo, nome social E email.
    public ResponseEntity<Page<User>> findAllUsersByFilterAnd(
            @RequestParam(defaultValue = "") String nomeCompleto,
            @RequestParam(defaultValue = "") String nomeSocial,
            @RequestParam(defaultValue = "") String email,
            Pageable pageable
    ){
        Page<User> result = userService.findAllUsersByFilterAnd(nomeCompleto, nomeSocial, email, pageable);
        return ResponseEntity.ok(result);
    }
    @GetMapping("filterOr")
    //Retorna todos os usuários que possuem o prefixo em comum com o nome completo, nome social OU email.
    public ResponseEntity<Page<User>> findAllUsersByFilterOr(
            @RequestParam(defaultValue = "") String nomeCompleto,
            @RequestParam(defaultValue = "") String nomeSocial,
            @RequestParam(defaultValue = "") String email,
            Pageable pageable
    ){
        Page<User> result = userService.findAllUsersByFilterOr(nomeCompleto, nomeSocial, email, pageable);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @PostMapping("csv")
    public void registerUsersByCsv(@RequestParam("file") MultipartFile file) throws Exception{
        userService.registerUsersByCsv(file);
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("")
    public void deleteUserById(@RequestBody User user) {
        userService.deleteUserById(user.getId());
    }
}
