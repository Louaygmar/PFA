package com.projet.stage.Service;


import com.projet.stage.Entity.Client;
import com.projet.stage.Entity.Freelancer;

import java.util.List;
import java.util.Optional;

public interface FreelancerService {
    Freelancer updateprofil(Freelancer freelancer);
    Freelancer ajouterFreelancer (Freelancer freelancer);
    Freelancer modifierFreelancer (Freelancer freelancer);
    List<Freelancer> listerFreelancer();
    void  SupprimerFreelancer (Long id);
    Optional<Freelancer > listeFreelancerById(Long id);
}
