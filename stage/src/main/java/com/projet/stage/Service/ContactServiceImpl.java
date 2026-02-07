package com.projet.stage.Service;


import com.projet.stage.Entity.Contact;

import com.projet.stage.Repositary.ContactRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    ContactRepositiry contactReposiitiry;
    @Override
    public Contact ajouterContact(Contact contact) {
        return contactReposiitiry.save(contact);
    }



    @Override
    public List<Contact> listerContact() {
        return contactReposiitiry.findAll();
    }
    @Override
    public void SupprimerContact(Long id) {
        contactReposiitiry.deleteById(id);
    }



}
