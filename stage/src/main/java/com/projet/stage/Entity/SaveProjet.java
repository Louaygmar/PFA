package com.projet.stage.Entity;

import jakarta.persistence.*;

public class SaveProjet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String titre;
    private String description ;
    private String experiance ;
    private String budget;
    private String delai;
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String ig;
    private Long idClient;
    public static Projet toEntity(SaveProjet model)
    {
        if (model==null){
            return  null;
        }
        Projet projet=new Projet();
        projet.setId(model.getId());
        projet.setTitre(model.getTitre());
        projet.setDescription(model.getDescription());
        projet.setExperiance(model.getExperiance());
        projet.setBudget(model.getBudget());
        projet.setDelai(model.getDelai());
        projet.setIg(model.getIg());


        return projet;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperiance() {
        return experiance;
    }

    public void setExperiance(String experiance) {
        this.experiance = experiance;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDelai() {
        return delai;
    }

    public void setDelai(String delai) {
        this.delai = delai;
    }

    public String getIg() {
        return ig;
    }

    public void setIg(String ig) {
        this.ig = ig;
    }

    public Long getIdClient() {
        return idClient;
    }

    public void setIdClient(Long idClient) {
        this.idClient = idClient;
    }
}
