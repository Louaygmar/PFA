package com.projet.stage.Service;

import com.projet.stage.Entity.*;
import com.projet.stage.Repositary.FreelancerRepositry;
import com.projet.stage.Repositary.ProjetRepositiry;
import com.projet.stage.Repositary.PropositionRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class propositionServiceempl  implements PropositionService {

    @Autowired
    FreelancerRepositry freelancerRepositry;
    @Autowired
    PropositionRepositiry propositionRepositiry;
    @Autowired
    ProjetRepositiry projetRepositiry;
    @Autowired
    ProjetService projetService;
    @Autowired
    FreelancerService freelancerService ;
    @Override
    public Proposition ajouterProposition(SaveProposition model) {
        Optional<Projet>projet=projetService.listeProjetById(model.getIdprojet());
        Optional<Freelancer>freelancer=freelancerService.listeFreelancerById(model.getIdfreelancer());
        if(projet.isPresent() && freelancer.isPresent()){
            return propositionRepositiry.save(new Proposition(model.getMontant(),model.getDuree(),model.getDescription(),projet.get(),freelancer.get()));
        }
        else
            return propositionRepositiry.save(new Proposition(model.getMontant(),model.getDuree(),model.getDescription(),projet.get(),freelancer.get()));
    }

    @Override
    public List<Proposition> ListerProposition() {
        return propositionRepositiry.findAll();
    }

    @Override
    public Optional<Proposition> listePropositionById(Long id) {
        return propositionRepositiry.findById(id);
    }

    @Override
    public List<Proposition> getPropositionByFreelancer(Long idFreelancer) {
        return propositionRepositiry.findByFreelancerId(idFreelancer);
    }

    @Override
    public ResponseEntity<?> validaterProposition(ValidatePropositionRq validatePropositionRq) {
        Optional<Proposition> pr= propositionRepositiry.findById(validatePropositionRq.getIdProposition());
        if (pr.isPresent()){
            Proposition res =pr.get();
            res.setStatue(2);
            return new ResponseEntity<>(propositionRepositiry.save(res), HttpStatus.OK);
        }
        return new ResponseEntity<>(" not Found " ,HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<?> annulerPropsition(Long id) {
        Optional<Proposition> pr= propositionRepositiry.findById(id);
        if (pr.isPresent()){
            Proposition res =pr.get();
            res.setStatue(1);
            return new ResponseEntity<>(propositionRepositiry.save(res), HttpStatus.OK);
        }
        return new ResponseEntity<>(" not Found " ,HttpStatus.BAD_REQUEST);
    }

    @Override
    public List<Proposition> findByProjetId(Long idProjet) {
        return propositionRepositiry .findByProjetId(idProjet);
    }

    @Override
    public List<Proposition> getPropositionsByProjetAndClient(Long idProjet, Long idClient) {
        Projet projet = projetRepositiry.findById(idProjet)
                .orElseThrow(() -> new RuntimeException("Projet non trouvé"));
        if (!projet.getClient().getId().equals(idClient)) {
            throw new RuntimeException("Ce projet n'appartient pas à ce client");
        }
        return propositionRepositiry.findByProjetId(idProjet);
    }
}
