package ca.sheridancollege.project;
import java.util.ArrayList;



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

    private static ArrayList<WarCard> cards = new ArrayList<WarCard>(52);

        public static void createDeck(){

            for (WarCard.Suit suit : WarCard.Suit.values()) {
                for (WarCard.Rank rank: WarCard.Rank.values()) {
                    WarCard card = new WarCard(rank,suit);
                    cards.add(card);
                }

            }

        }
        public static ArrayList<WarCard> getDeck(){
            createDeck();
            return cards;
        }

      //  public static void main (String[] args){
            //createDeck();

        //}









}
