package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarCard extends Card{
    private Suit suit;
    private Rank rank;

    public WarCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public enum Suit { SPADES, CLUBS, HEARTS, DIAMONDS}
    public enum Rank {TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE}

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank Rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
    public int compare(WarCard card){
        int rank1 = this.getRank().ordinal();
        int rank2 = card.getRank().ordinal();
        if(rank1 > rank2){
            return 1;
        }
        else if(rank1 < rank2){
            return -1;
        }
        else
            return 0;
    }

    public String toString(){
        return "Card = Rank:"+rank+"      Suit: "+suit;
    }
}
