package com.apiSpringBoot.apiSpringBoot.controllers;

import com.apiSpringBoot.apiSpringBoot.models.User;

import com.apiSpringBoot.apiSpringBoot.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    public ResponseEntity<Page<User>> findAllUsers(Pageable pageable){
        Page<User> result = userRepository.findAll(pageable);
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
        Page<User> result = userRepository.findAllUsersByFilterAnd(nomeCompleto, nomeSocial, email, pageable);
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
        Page<User> result = userRepository.findAllUsersByFilterOr(nomeCompleto, nomeSocial, email, pageable);
        return ResponseEntity.ok(result);
    }
    @PostMapping("")
    public User registerUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @DeleteMapping("")
    public void deleteUser(@RequestBody User user) {
        userRepository.delete(user);
    }
}
