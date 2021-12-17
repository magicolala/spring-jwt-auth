package com.example.evalspringjwtauth.restcontroller;

import com.example.evalspringjwtauth.entity.RoleUtilisateur;
import com.example.evalspringjwtauth.entity.Utilisateur;
import com.example.evalspringjwtauth.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SecuredRestController {

    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public String everyoneEndpoint() {
        return "Tout le monde a accès";

    }

    @GetMapping("/secured")
    public String securedEndpoint() {
        return "User Sécurisé";
    }

    @GetMapping("/secured/admin")
    public String adminEndPoint() {
        return "Admin sécurisé";
    }


    // Pour s'enregister en tant que utilisateur
    @PostMapping("/register")
    public ResponseEntity<Utilisateur> register(@RequestBody Utilisateur utilisateur) {

        try {
            utilisateur.setRole(RoleUtilisateur.USER);
            utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
            Utilisateur _utilisateur = utilisateurRepository.save(utilisateur);

            return new ResponseEntity<>(_utilisateur, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
