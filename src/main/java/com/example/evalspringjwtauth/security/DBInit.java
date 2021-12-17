package com.example.evalspringjwtauth.security;

import com.example.evalspringjwtauth.entity.RoleUtilisateur;
import com.example.evalspringjwtauth.entity.Utilisateur;
import com.example.evalspringjwtauth.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DBInit implements CommandLineRunner {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder       passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        utilisateurRepository.save(new Utilisateur("admin", passwordEncoder.encode("123"), RoleUtilisateur.ADMIN));
//        utilisateurRepository.save(new Utilisateur("user", passwordEncoder.encode("123"), RoleUtilisateur.USER));
    }

}
