package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarCard extends Card{
    private Suit suit;
    private Rank rank;

    public WarCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

/*
    public int compareCards(WarCard card) {
        if(this.getRank().compareTo(card.getRank()) < 0){
            return 1;
        }
        else if(this.getRank().compareTo(card.getRank()) > 0){
            return -1;
        }
        else
            return 0;
    }
*/
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

    public int compareTo(WarCard card){
        if(this.getRank().compareTo(card.getRank()) < 0){
            return 1;
        }
        else if(this.getRank().compareTo(card.getRank()) > 0){
            return -1;
        }
        else
            return 0;
    }

    public String toString(){
        return "Card = Rank:"+rank+"      Suit: "+suit;
    }
}
