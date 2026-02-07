package com.projet.stage.Repositary;

import com.projet.stage.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositiry  extends JpaRepository<Admin, Long> {

    boolean existsByEmail(String email);

    Admin findAdminByEmail(String email);

}
