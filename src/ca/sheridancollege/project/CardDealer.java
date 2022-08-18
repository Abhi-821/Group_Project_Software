package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class CardDealer {

    private static ArrayList<WarCard>  player1Hand = new ArrayList<WarCard>();
    private static ArrayList<WarCard>  player2Hand = new ArrayList<WarCard>();

    public static ArrayList<WarCard> getPlayer1Hand() {
        return player1Hand;
    }

    public static ArrayList<WarCard> getPlayer2Hand() {
        return player2Hand;
    }

    public static void dealCards() {
        Collections.shuffle(Deck.getDeck());
        ArrayList<WarCard> cards = Deck.getDeck();
        WarCard temp;
            for (int i = 0; i < 26; i++) {
                temp = cards.get(i);
                player1Hand.add(temp);
            }
            for (int i = 26; i < 51; i++) {
                temp = cards.get(i);
                player2Hand.add(temp);
            }
        }
    }


