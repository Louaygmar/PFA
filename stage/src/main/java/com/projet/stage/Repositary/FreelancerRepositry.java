package com.projet.stage.Repositary;
import com.projet.stage.Entity.Freelancer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FreelancerRepositry extends JpaRepository<Freelancer,Long> {

    boolean existsByEmail (String email);

    Freelancer findFreelancerByEmail (String email);


}
