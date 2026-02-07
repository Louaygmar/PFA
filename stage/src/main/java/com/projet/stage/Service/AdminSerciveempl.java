package com.projet.stage.Service;

import com.projet.stage.Entity.Admin;
import com.projet.stage.Repositary.AdminRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminSerciveempl implements  AdminService {
    @Autowired
    AdminRepositiry adminRepositiry ;
    @Override
    public Admin ajouterAdmin(Admin admin) {
        return adminRepositiry.save(admin);
    }



    @Override
    public Admin modifierAdmin(Admin admin) {
        return adminRepositiry.save(admin);
    }

    @Override
    public List<Admin> listerAdmin() {
        return adminRepositiry.findAll();
    }

    @Override
    public void SupprimerAdmin(Long id) {
        adminRepositiry.deleteById(id);
    }

    @Override
    public Optional<Admin> listeAdminById(Long id) {
        return adminRepositiry.findById(id);
    }
}
