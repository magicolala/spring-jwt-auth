package com.example.evalspringjwtauth.repository;

import com.example.evalspringjwtauth.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByLogin(String username);

}
