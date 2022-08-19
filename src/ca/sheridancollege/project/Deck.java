package ca.sheridancollege.project;
import java.util.ArrayList;
 /*
 @Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
 Description: a model class that creates and represents the deck.
  */

public class Deck extends GroupOfCards{
    private int deckSize;

    public Deck(int size) {
        super(size);
    }

    public int getDeckSize() {
        return deckSize;
    }

    public void setDeckSize(int deckSize) {
        this.deckSize = deckSize;
    }

    //ArrayList that acts as a deck and has the War cards
    private static ArrayList<WarCard> cards = new ArrayList<WarCard>(52);

        public static void createDeck(){
            //using War cards enums suit and rank to create a deck
            for (WarCard.Suit suit : WarCard.Suit.values()) {
                for (WarCard.Rank rank: WarCard.Rank.values()) {
                    WarCard card = new WarCard(rank,suit);
                    cards.add(card);
                }
            }
        }
        //to get the deck
        public static ArrayList<WarCard> getDeck(){
            return cards;
        }











}
