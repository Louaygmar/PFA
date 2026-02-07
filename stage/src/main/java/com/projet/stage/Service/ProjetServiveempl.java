package com.projet.stage.Service;

import com.projet.stage.Entity.Client;
import com.projet.stage.Entity.Projet;
import com.projet.stage.Entity.SaveProjet;
import com.projet.stage.Repositary.ClientRepositiry;
import com.projet.stage.Repositary.ProjetRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
@Service
public class ProjetServiveempl implements ProjetService {
    @Autowired
    ProjetRepositiry projetRepositiry;
    @Autowired
    ClientRepositiry clientRepositiry;
    @Override
    public Projet ajouterProjet(SaveProjet model) {
        Projet projet= SaveProjet.toEntity(model);
        System.out.println("idClient" + model.getIdClient());
        Client client=clientRepositiry.findById(model.getIdClient()).get();
        projet.setClient(client);
        return  projetRepositiry.save(projet);

    }

    // @Override
    // public Projet modifierProjet(Saveprojet model) {
    //return projetRepository.save(model);
    // }

    @Override
    public List<Projet> ListerProjet() {
        return projetRepositiry.findAll();
    }

    @Override
    public Optional<Projet>listeProjetById(Long id) {
        return projetRepositiry.findById(id);
    }

    @Override
    public Projet getById(Long id) {
        return  projetRepositiry.findById(id).get();
    }

    @Override
    public List<Projet> getProjetByClient(Long idClient) {
        return projetRepositiry.findByClientId(idClient);
    }


}
