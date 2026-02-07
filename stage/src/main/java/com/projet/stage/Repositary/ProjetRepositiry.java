package com.projet.stage.Repositary;
import com.projet.stage.Entity.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjetRepositiry extends JpaRepository<Projet,Long>{

    List<Projet> findByClientId(Long idClient);
}
