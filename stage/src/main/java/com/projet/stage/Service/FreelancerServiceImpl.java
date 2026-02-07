package com.projet.stage.Service;


import com.projet.stage.Entity.Freelancer;
import com.projet.stage.Repositary.FreelancerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FreelancerServiceImpl implements FreelancerService {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Autowired
    FreelancerRepositry freelancerRepositry;

    @Override
    public Freelancer updateprofil(Freelancer freelancer) {
        Optional<Freelancer> optionalFreelancer = freelancerRepositry.findById(freelancer.getId());
        if (optionalFreelancer.isPresent()) {
            Freelancer freelancer1 = optionalFreelancer.get();
            freelancer1.setNom(freelancer.getNom());
            freelancer1.setPrenom(freelancer.getPrenom());
            freelancer1.setEmail(freelancer.getEmail());
            freelancer1.setMdp(this.bCryptPasswordEncoder.encode(freelancer.getMdp()));

            freelancer1.setTlf(freelancer.getTlf());





            return freelancerRepositry.save(freelancer);
        } else {
            throw new RuntimeException("employer not found");
        }
    }

    @Override
    public Freelancer ajouterFreelancer(Freelancer freelancer) {
        return freelancerRepositry.save(freelancer);
    }



    @Override
    public Freelancer modifierFreelancer(Freelancer freelancer) {
        return freelancerRepositry.save(freelancer);
    }

    @Override
    public List<Freelancer> listerFreelancer() {
        return freelancerRepositry.findAll();
    }

    @Override
    public void SupprimerFreelancer(Long id) {
        freelancerRepositry.deleteById(id);
    }

    @Override
    public Optional<Freelancer> listeFreelancerById(Long id) {
        return freelancerRepositry.findById(id);
    }


}
