package com.projet.stage.Repositary;

import com.projet.stage.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepositiry  extends JpaRepository<Client, Long> {

    boolean existsByEmail(String email);;

    Client findClientByEmail(String email);
}