package com.projet.stage.Service;

import com.projet.stage.Entity.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PropositionService {
   Proposition ajouterProposition(SaveProposition model);
    //Projet modifierProjet ( SaveProjet  model);
    List<Proposition> ListerProposition ();

    Optional<Proposition> listePropositionById (Long id);
    List<Proposition> getPropositionByFreelancer (Long idFreelancer);
    ResponseEntity<?>validaterProposition(ValidatePropositionRq validatePropositionRq);
    ResponseEntity<?>annulerPropsition (Long  id );
    List<Proposition>findByProjetId ( Long idProjet);

    List<Proposition> getPropositionsByProjetAndClient(Long idProjet, Long idClient);
}

