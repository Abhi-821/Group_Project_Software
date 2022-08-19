package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
 /*
 @Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
 Description: A class that is only reponsible for dealing cards into two players.
  */
public class CardDealer {
    //two hand Arraylists for each player to hold the dealt cards.
    private static ArrayList<WarCard>  player1Hand = new ArrayList<WarCard>();
    private static ArrayList<WarCard>  player2Hand = new ArrayList<WarCard>();

    //to get the private hand of player1
    public static ArrayList<WarCard> getPlayer1Hand() {
        return player1Hand;
    }
     //to get the private hand of player2
    public static ArrayList<WarCard> getPlayer2Hand() {
        return player2Hand;
    }

     //the method that shuffles the cards in random order then divides them into two.
    public static void dealCards() {
        Collections.shuffle(Deck.getDeck());
        ArrayList<WarCard> cards = Deck.getDeck();
        WarCard temp;
            for (int i = 0; i < 26; i++) {
                temp = cards.get(i);
                player1Hand.add(temp);
            }
            for (int i = 26; i < 52; i++) {
                temp = cards.get(i);
                player2Hand.add(temp);
            }
        }
    }


