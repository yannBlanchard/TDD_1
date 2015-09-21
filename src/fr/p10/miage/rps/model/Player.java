package fr.p10.miage.rps.model;

import clover.org.apache.commons.lang.ObjectUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by yablanch on 21/09/2015.
 */
public class Player {
    private String nom;
    private  int score;
    private List<RPSEnum> ListMouvement = new ArrayList<>();
    private static int nbMouvment = 20;


    public Player(String nom,List<RPSEnum> mouvement){
        this.nom = nom;
        this.ListMouvement = mouvement;
    }

    public Player(String nom){
        Random random= new Random();

        this.nom = nom;
        for(int i = 0;i<nbMouvment;i++) {
            switch (random.nextInt(2)) {
                case 0:
                    this.ListMouvement.add(RPSEnum.ROCK);
                    break;
                case 1:
                    this.ListMouvement.add(RPSEnum.PAPER);
                    break;
                case 2:
                    this.ListMouvement.add(RPSEnum.SCISSORS);
                    break;
                default:
                    break;
            }
        }
    }

    public static int getNbMouvment() {
        return nbMouvment;
    }


    public String getNom() {
        return nom;
    }

    public int getScore() {
        return score;
    }

    public RPSEnum getNextMove(){
        Iterator<RPSEnum> iter = ListMouvement.iterator();
        if(iter ==null){
            ListMouvement.iterator();
        }
        else{
            if(iter.hasNext()){
                return iter.next();
            }
            else{
                return null;
            }
        }
        return iter.next();
    }

    public void setScore(int score) {
        this.score = score;
    }



}
