package com.projet.stage.Entity;

public class ValidatePropositionRq {
    private Long id ;
    private long idProposition;

    public int getStatue() {
        return statue;
    }

    public void setStatue(int statue) {
        this.statue = statue;
    }

    public long getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(long idProposition) {
        this.idProposition = idProposition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private  int statue ;
}
