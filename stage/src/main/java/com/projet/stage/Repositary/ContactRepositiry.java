package com.projet.stage.Repositary;


import com.projet.stage.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepositiry extends JpaRepository<Contact, Long> {
    boolean existsByEmail(String email);

    Contact findAdminByEmail(String email);
}
