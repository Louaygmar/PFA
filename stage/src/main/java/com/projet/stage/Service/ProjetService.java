package com.projet.stage.Service;

import com.projet.stage.Entity.Admin;
import com.projet.stage.Entity.Projet;
import com.projet.stage.Entity.SaveProjet;

import java.util.List;
import java.util.Optional;

public interface ProjetService {
    Projet ajouterProjet(SaveProjet  model);
   //Projet modifierProjet ( SaveProjet  model);
    List<Projet>ListerProjet();

    Optional<Projet >listeProjetById (Long id);
    Projet getById(Long id );

    List<Projet> getProjetByClient(Long idClient);
}
