package com.apiSpringBoot.apiSpringBoot.repositories;

import com.apiSpringBoot.apiSpringBoot.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT user FROM User user WHERE" +
            " LOWER(user.nomeCompleto) LIKE LOWER(CONCAT(:nomeCompleto, '%')) AND" +
            " LOWER(user.nomeSocial) LIKE LOWER(CONCAT(:nomeSocial, '%')) AND" +
            " LOWER(user.email) LIKE LOWER(CONCAT(:email, '%'))")
    Page<User> findAllUsersByFilterAnd(String nomeCompleto, String nomeSocial, String email, Pageable pageable);

    @Query(value = "SELECT user FROM User user WHERE" +
            " (:nomeCompleto <> '' AND LOWER(user.nomeCompleto) LIKE LOWER(CONCAT(:nomeCompleto, '%'))) OR" +
            " (:nomeSocial <> '' AND LOWER(user.nomeSocial) LIKE LOWER(CONCAT(:nomeSocial, '%'))) OR" +
            " (:email <> '' AND LOWER(user.email) LIKE LOWER(CONCAT(:email, '%')))")
    Page<User> findAllUsersByFilterOr(String nomeCompleto, String nomeSocial, String email, Pageable pageable);
}
