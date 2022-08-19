package ca.sheridancollege.project;

import java.util.ArrayList;
/*
@Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
Description: this is the controller class that interacts with different models and the view class
 */
public class WarPlayer extends Player{

    //arraylist to hold hand of each player
    private ArrayList<WarCard> player1Hand;
    private ArrayList<WarCard> player2Hand;
    //arraylist to hold cards in case of war
    private ArrayList<WarCard> player1War= new ArrayList<WarCard>();
    private ArrayList<WarCard> player2War = new ArrayList<WarCard>();
    WarGame self = new WarGame();

    //hold the card player in currently playing
    private WarCard currentCard;

    public WarPlayer(String name) {
        super(name);

    }
    //getters and setters
    public ArrayList<WarCard> getPlayer1War() {
        return player1War;
    }

    public ArrayList<WarCard> getPlayer2War() {
        return player2War;
    }

    public void setPlayer1War(ArrayList<WarCard> player1War) {
        this.player1War = player1War;
    }

    public void setPlayer2War(ArrayList<WarCard> player2War) {
        this.player2War = player2War;
    }

    public ArrayList<WarCard> getPlayer1Hand() {
        return player1Hand;
    }

    public ArrayList<WarCard> getPlayer2Hand() {
        return player2Hand;
    }

    //both players get the dealt cards from the dealer
    public void getHand(){
        player1Hand = CardDealer.getPlayer1Hand();
        player2Hand = CardDealer.getPlayer2Hand();
    }
    int i = 1;
    @Override
    public void play() {}

    //for players to play a card
    public WarCard playCard(int playerNum){
        //player 1 play a card
        if(playerNum == 1){
            try {
                //remove a card from the top of the deck and play it.
                currentCard = player1Hand.get(0);
                player1Hand.remove(0);
                player1Hand.add(currentCard);
            } catch (IndexOutOfBoundsException e) {
                self.declareWinner();
            }
            //player 2 play a card
        } else if (playerNum == 2){
            try {
                //remove a card from the top of the deck and play it.
                currentCard = player2Hand.get(0);
                player2Hand.remove(0);
                player2Hand.add(currentCard);
            } catch (IndexOutOfBoundsException e) {
                self.declareWinner();
            }
        }
        //return the card so it can be displayed
        return currentCard;
    }
    //give losers card to the winner
    public void switchCards(int higher){
        //if player one won
        if(higher == 1){
            try {
                //remove the card from player2 give it to player1
                WarCard card = player2Hand.remove(player2Hand.size() - 1);
                player1Hand.add(card);
            } catch ( IndexOutOfBoundsException e) {
                self.declareWinner();
            }
            //if player two won
        } else if (higher == 2) {
            try {
                //remove the card from player1 give it to player2
                WarCard card = player1Hand.remove(player1Hand.size() - 1);
                player2Hand.add(card);
            } catch (IndexOutOfBoundsException e) {
                self.declareWinner();
            }
        }
    }

    //in case of war player1 draws 3 cards
    public void player1Draw3Cards(boolean clear){
        //if it's not a recursive war clear the array of the old cards
        if(clear) {
            getPlayer1War().clear();
        }
        //remove cards from hand add them to another temporary array
        for(int i=0 ; i <3 ; i++){
            WarCard card1;
            try {
                card1 = player1Hand.get(0);
                player1Hand.remove(0);
                getPlayer1War().add(card1);
            } catch (IndexOutOfBoundsException e) {
                self.declareWinner();
            }

        }
    }
    //in case of war player2 draws 3 cards
    public void player2Draw3Cards(boolean clear){
        //if it's not a recursive war clear the array of the old cards
        if(clear) {
            getPlayer2War().clear();
        }
        //remove cards from hand add them to another temporary array
        for(int i=0 ; i <3 ; i++) {
            WarCard card2;
            try {
                card2 = player2Hand.get(0);
                player2Hand.remove(0);
                getPlayer2War().add(card2);
            } catch (IndexOutOfBoundsException e) {
                self.declareWinner();
            }
        }
    }
    //based on who won give them their all cards played i.e their cards and opponenets
    public void warWinner(int playerNum){
        if(playerNum == 1) {
            for(int i =0 ; i< player2War.size() ; i++){
                getPlayer1Hand().add(getPlayer2War().get(i));
                getPlayer1Hand().add(getPlayer1War().get(i));
            }
        }
        if(playerNum == 2) {
            for(int i =0 ; i< player2War.size() ; i++){
                getPlayer2Hand().add(getPlayer1War().get(i));
                getPlayer2Hand().add(getPlayer2War().get(i));
            }
        }
    }

    //to flip the first card out of the 3 played in case of a war
    public WarCard flipCard(int playerNum){
        if(playerNum == 1) {
            return getPlayer1War().get(getPlayer1War().size()-1);
        }
        else if(playerNum == 2){
            return getPlayer2War().get(getPlayer2War().size()-1);
        }
        return null;
    }



}


