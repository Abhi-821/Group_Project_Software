package ca.sheridancollege.project;

import java.util.Collections;
import java.util.List;

public class CardDealer {

    public static List dealCards(int type){

        Collections.shuffle(Deck.getDeck());


        List <WarCard>  player1Cards= Deck.getDeck().subList(0,26);
        List <WarCard> player2Cards= Deck.getDeck().subList(26,52);


        if(type == 1){
            return player1Cards;
        }
        else if (type == 2){
            return player2Cards;
        }
        else
            return null;


    }
}
