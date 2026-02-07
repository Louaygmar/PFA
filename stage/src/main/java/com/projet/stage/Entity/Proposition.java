package com.projet.stage.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Proposition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String montant ;
    private  String duree ;
    private  int statue = 0;

    public Proposition() {
    }

    private  String description ;
    @ManyToOne
    Projet projet;
    @ManyToOne
    Freelancer freelancer;

    public Proposition(String montant, String duree, String description, Projet projet, Freelancer freelancer) {
        this.montant = montant;
        this.duree = duree;
        this.description = description;
        this.projet = projet;
        this.freelancer = freelancer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public Freelancer getFreelancer() {
        return freelancer;
    }

    public void setFreelancer(Freelancer freelancer) {
        this.freelancer = freelancer;
    }
}
