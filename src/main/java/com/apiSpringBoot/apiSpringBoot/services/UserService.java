package com.apiSpringBoot.apiSpringBoot.services;

import com.apiSpringBoot.apiSpringBoot.models.User;
import com.apiSpringBoot.apiSpringBoot.repositories.UserRepository;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<User> findAllUsers(Pageable pageable){
        Page<User> result = userRepository.findAll(pageable);
        return result;
    }

    public Page<User> findAllUsersByFilter(String filter, Pageable pageable){
        Page<User> result = userRepository.findAllUsersByFilter(filter, pageable);
        return result;
    }

    public Page<User> findAllUsersByFilterAnd(
            String nomeCompleto,
            String nomeSocial,
            String email,
            Pageable pageable
    ){
        Page<User> result = userRepository.findAllUsersByFilterAnd(nomeCompleto, nomeSocial, email, pageable);
        return result;
    }

    public Page<User> findAllUsersByFilterOr(
            String nomeCompleto,
            String nomeSocial,
            String email,
            Pageable pageable
    ){
        Page<User> result = userRepository.findAllUsersByFilterOr(nomeCompleto, nomeSocial, email, pageable);
        return result;
    }
    public User registerUser(User user){
        return userRepository.save(user);
    }

    public void registerUsersByCsv(MultipartFile file) throws Exception{
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        settings.getFormat().setLineSeparator("\n");
        CsvParser parser = new CsvParser(settings);
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

    public User updateUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
