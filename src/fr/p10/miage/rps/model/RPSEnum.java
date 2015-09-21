package fr.p10.miage.rps.model;

/**
 * Created by yablanch on 14/09/2015.
 *
 */




public enum RPSEnum {
    ROCK("Rock"),
    PAPER("Paper"),
    SCISSORS("Scissors");



    private final String nom;

    RPSEnum(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
