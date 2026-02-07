package com.projet.stage.RestController;



import com.projet.stage.Entity.Contact;

import com.projet.stage.Service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;


import java.util.List;


@RequestMapping(value = "/contact")
@CrossOrigin("*")
@RestController

public class ContactRestController {
    @Autowired
    ContactService contactService;


    @RequestMapping(method = RequestMethod.POST )
    public Contact AjouterContact (@RequestBody Contact contact){
        return contactService.ajouterContact(contact);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Contact> AfficherContact(){
        return contactService.listerContact();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerContact(@PathVariable("id") Long id){
        contactService.SupprimerContact(id);

    }
}
