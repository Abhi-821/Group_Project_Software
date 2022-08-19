package ca.sheridancollege.project;

/*
@Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
Description: a model class representing war card.
 */
public class WarCard extends Card{
    private Suit suit;
    private Rank rank;

    //we need suit and rank to make a war card
    public WarCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //enums that hold suit and rank
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
    //a method to compare ranks of cards
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
    //to print the cards
    public String toString(){
        return "Card = Rank:"+rank+"      Suit: "+suit;
    }
}
