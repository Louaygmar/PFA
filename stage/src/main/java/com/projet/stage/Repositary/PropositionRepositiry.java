package com.projet.stage.Repositary;

import com.projet.stage.Entity.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropositionRepositiry extends JpaRepository<Proposition,Long > {
    List<Proposition> findByFreelancerId(Long idFreelancer);

    List<Proposition> findByProjetId(Long idProjet);
}
