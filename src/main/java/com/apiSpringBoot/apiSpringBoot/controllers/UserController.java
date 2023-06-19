package com.apiSpringBoot.apiSpringBoot.controllers;

import com.apiSpringBoot.apiSpringBoot.models.User;

import com.apiSpringBoot.apiSpringBoot.repositories.UserRepository;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.common.record.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

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

    @PostMapping("csv")
    public void registerUsersByCsv(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream inputStream = file.getInputStream();
        CsvParserSettings setting = new CsvParserSettings();
        setting.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(setting);
        parser.beginParsing(inputStream);

        for (Record record = parser.parseNextRecord(); record != null; record = parser.parseNextRecord()){
            User user = new User();
            user.setNomeCompleto(record.getString("Nome completo"));
            user.setNomeSocial(record.getString("Nome social"));
            user.setDataNasc(record.getString("Data de nascimento"));
            user.setCodigo(Long.parseLong(record.getString("Código")));
            user.setSexo(record.getString("Sexo"));
            user.setEmail(record.getString("E-mail"));
            user.setEstado(record.getString("Estado"));
            user.setMunicipio(record.getString("Município"));
            user.setNumAcessos(Long.parseLong(record.getString("Número de acessos ao curso")));
            user.setSituacao(record.getString("Situação no curso"));
            user.setDataVinculo(record.getString("Data de vínculo"));
            if (!userRepository.existsByCodigo(user.getCodigo()) && user.getCodigo() != null)
                userRepository.save(user);
        }
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
