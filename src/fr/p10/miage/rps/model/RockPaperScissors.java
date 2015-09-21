package fr.p10.miage.rps.model;

/**
 * Created by yablanch on 14/09/2015.
 * Models the behavior of RPS game
 */
public class RockPaperScissors {
    public Result play(RPSEnum p1,RPSEnum p2) {
        if ((p1 == RPSEnum.ROCK && p2 == RPSEnum.SCISSORS)
                ||
                (p1 == RPSEnum.PAPER && p2 == RPSEnum.ROCK)
                ||
                (p1 == RPSEnum.SCISSORS && p2 == RPSEnum.PAPER))
            return Result.WIN;
        if(p1 == p2)
                return Result.TIE;
        else
            return Result.LOST;
    }

    public Result play(Player p1, Player p2){
        while(p1.getNextMove()!= null && p2.getNextMove()!=null){

        }
        return Result.LOST;
    }
}
