package com.projet.stage.RestController;

import com.projet.stage.Entity.Freelancer;
import com.projet.stage.Repositary.FreelancerRepositry;
import com.projet.stage.Service.FreelancerService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@RequestMapping(value = "/freelancer")
@CrossOrigin("*")
@RestController
public class FreelancerRestController {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    FreelancerRepositry freelancerRepositry;

    @Autowired
    FreelancerService freelancerService;




    @RequestMapping(method = RequestMethod.POST )
    ResponseEntity<?> AjouterFreelancer(@RequestBody Freelancer freelancer){

        HashMap<String, Object> response = new HashMap<>();
        if(freelancerRepositry.existsByEmail(freelancer.getEmail())){
            response.put("message", "email exist deja !");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else{
            freelancer.setMdp(this.bCryptPasswordEncoder.encode(freelancer.getMdp()));
            Freelancer savedUser = freelancerRepositry.save(freelancer);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Freelancer> AfficherFreelancer(){
        return freelancerService.listerFreelancer();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )
    public void SupprimerFreelancer(@PathVariable("id") Long id){
        freelancerService.SupprimerFreelancer(id);

    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Freelancer> getFreelancerById(@PathVariable("id") Long id){

        Optional<Freelancer> freelancer = freelancerService.listeFreelancerById(id) ;
        return freelancer;

    }

    @RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
    public Freelancer ModifierFreelancer(@PathVariable("id")Long id, @RequestBody Freelancer freelancer){
        freelancer.setMdp(this.bCryptPasswordEncoder.encode(freelancer.getMdp()));
        Freelancer savedUser = freelancerRepositry.save(freelancer);

        Freelancer newFreelancer = freelancerService.modifierFreelancer(freelancer);
        return newFreelancer;
    }

    @PutMapping("/mod/{id}")


    public ResponseEntity<Map<String, Object>> updatePack(@PathVariable Long id, @RequestBody Freelancer freelancer) {
        freelancer.setId(id); // Ensure the id from the path is set in the DTO

        Map<String, Object> response = new HashMap<>();
        try {
            Freelancer updatedFreelancer = freelancerService.updateprofil(freelancer);
            response.put("pack", updatedFreelancer);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (RuntimeException e) {
            response.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }


    }



@PostMapping("/login")
public ResponseEntity<Map<String, Object>> loginFreelancer(@RequestBody Freelancer freelancer) {
    System.out.println("in login-freelancer"+freelancer);
    HashMap<String, Object> response = new HashMap<>();

    Freelancer userFromDB = freelancerRepositry.findFreelancerByEmail(freelancer.getEmail());
    System.out.println("userFromDB+admin"+userFromDB);
    if (userFromDB == null) {
        response.put("message", "Freelanceer not found!");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    } else {
        boolean compare = this.bCryptPasswordEncoder.matches(freelancer.getMdp(), userFromDB.getMdp());
        System.out.println("compare"+compare);
        if (!compare) {
            response.put("message", "Password incorrect!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }else
        {
            String token = Jwts.builder()
                    .claim("data", userFromDB)
                    .signWith(SignatureAlgorithm.HS256, "SECRET")
                    .compact();
            response.put("token", token);
            System.out.println("hhh");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }


    }
}
}
