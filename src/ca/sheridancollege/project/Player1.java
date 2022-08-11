package ca.sheridancollege.project;

import java.util.List;

public class Player1 extends Player{

    public static List hand = CardDealer.dealCards(1);
    private static Object currentCard;
    public Player1(String name) {
        super(name);
    }


    public static Object getCurrentCard() {
        return currentCard;
    }

    public void play(){

    }
    public static void playCard(){
         //int currentSize = hand.size();
         //currentCard =  hand.get(currentSize);

        //System.out.println("Player1 " +WarGameView.name1+ "played:    " +currentCard);

        //player1.hand.remove(player1.hand.size()-1);
    }

}
