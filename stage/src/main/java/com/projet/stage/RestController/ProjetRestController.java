package com.projet.stage.RestController;

import com.projet.stage.Entity.Projet;
import com.projet.stage.Entity.Contact;
import com.projet.stage.Entity.Projet;
import com.projet.stage.Entity.SaveProjet;
import com.projet.stage.Service.ContactService;
import com.projet.stage.Service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value="/projet")
@CrossOrigin("*")
public class ProjetRestController {

    @Autowired
    ProjetService projetService;

    @RequestMapping(method = RequestMethod.POST )
    public Projet AjouterProjet (@RequestBody SaveProjet model){
        return projetService.ajouterProjet(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Projet> AfficherProjet(){
        return projetService.ListerProjet();
    }
    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Projet> getProjetById(@PathVariable("id") Long id){

        Optional<Projet> Projet = projetService.listeProjetById(id);
        return Projet;
    }
    @GetMapping("/get-id/{id}")
    public Projet getById(@PathVariable Long id)
    {
        return projetService.getById(id);
    }
    @GetMapping("/client/{idClient}/projet")
    public ResponseEntity<List<Projet>>getProjetByclient(@PathVariable Long idClient){
        List<Projet> projets = projetService.getProjetByClient(idClient);
        return  ResponseEntity.ok(projets);
    }
}

