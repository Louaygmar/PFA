package com.projet.stage.RestController;

import com.projet.stage.Entity.Contact;
import com.projet.stage.Entity.Proposition;
import com.projet.stage.Entity.SaveProposition;
import com.projet.stage.Entity.ValidatePropositionRq;
import com.projet.stage.Service.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping (value ="/proposition")
@CrossOrigin("*")
public class PropositionRestController {
    @Autowired
    PropositionService propositionService;

    @RequestMapping(method = RequestMethod.POST)
    public Proposition AjouterProposition(@RequestBody SaveProposition model) {
        return propositionService.ajouterProposition(model);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Proposition> AfficherPropositoion() {
        return propositionService.ListerProposition();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Proposition> getPropositionById(@PathVariable("id") Long id){

        Optional<Proposition> proposition = propositionService.listePropositionById(id);
        return proposition;
    }
    @GetMapping("/Freelancer/{idfreeancer}/proposition" )
    public ResponseEntity <List<Proposition>>getPropositionByFreelancer(@PathVariable Long idFreelancer)
    {return ResponseEntity.ok(propositionService.getPropositionByFreelancer(idFreelancer));
    }
    @PutMapping("validate-proposition")
    public ResponseEntity<?> listvalidate(@RequestBody ValidatePropositionRq validatePropositionRq){
        return propositionService.validaterProposition(validatePropositionRq);
    }

    @PutMapping("/annuler/{id}")
    public ResponseEntity<?> annulerproposition(@PathVariable("id") Long id){
        return propositionService.annulerPropsition(id);
    }
    @GetMapping("/projet/{idProjet}")
    public ResponseEntity<List<Proposition>> getPropositionsByProjet(@PathVariable Long idProjet) {
        List<Proposition> propositions = propositionService.findByProjetId(idProjet);
        return ResponseEntity.ok(propositions);
    }
    @GetMapping("/client/{idClient}/projet/{idProjet}")
    public ResponseEntity<List<Proposition>> getPropositionsByClientAndProjet(
            @PathVariable Long idClient,
            @PathVariable Long idProjet) {
        List<Proposition> propositions = propositionService.getPropositionsByProjetAndClient(idProjet, idClient);
        return ResponseEntity.ok(propositions);
    }

}
