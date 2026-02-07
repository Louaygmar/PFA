package com.projet.stage.Service;


import com.projet.stage.Entity.Contact;

import java.util.List;


public interface ContactService {
    Contact ajouterContact (Contact contact);
    List<Contact> listerContact();
    void  SupprimerContact(Long id);

}

