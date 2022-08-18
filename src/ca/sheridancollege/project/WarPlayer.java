package ca.sheridancollege.project;

import java.util.ArrayList;

public class WarPlayer extends Player{


    private ArrayList<WarCard> player1Hand;
    private ArrayList<WarCard> player2Hand;
    private ArrayList<WarCard> player1War= new ArrayList<WarCard>();
    private ArrayList<WarCard> player2War = new ArrayList<WarCard>();
    WarGame self = new WarGame();

    private WarCard currentCard;


    public WarPlayer(String name) {
        super(name);

    }

    public ArrayList<WarCard> getPlayer1War() {
        try {
            player1War.add(player1Hand.get(0));
        } catch (NullPointerException e) {
            self.declareWinner();
        }
        return player1War;
    }

    public ArrayList<WarCard> getPlayer2War() {
        try {
            player2War.add(player2Hand.get(0));
        } catch (NullPointerException e) {
            self.declareWinner();
        }
        return player2War;
    }

    public ArrayList<WarCard> getPlayer1Hand() {
        return player1Hand;
    }

    public ArrayList<WarCard> getPlayer2Hand() {
        return player2Hand;
    }


    public void getHand(int playerNum){
        player1Hand = CardDealer.getPlayer1Hand();
        player2Hand = CardDealer.getPlayer2Hand();
    }
    int i = 1;
    @Override
    public void play() {

    }
    public WarCard playCard(int playerNum){
        if(playerNum == 1){
            try {
                currentCard = player1Hand.get(0);
                player1Hand.remove(0);
                player1Hand.add(currentCard);
            } catch (NullPointerException e) {
                self.declareWinner();
            }
        } else if (playerNum == 2){
            try {
                currentCard = player2Hand.get(0);
                player2Hand.remove(0);
                player2Hand.add(currentCard);
            } catch (NullPointerException e) {
                self.declareWinner();
            }
        }
        return currentCard;
    }
    public void switchCards(int higher){
        if(higher == 1){
            try {
                WarCard card = player2Hand.remove(player2Hand.size() - 1);
                player1Hand.add(card);
            } catch (NullPointerException e) {
                self.declareWinner();
            }
        } else if (higher == 2) {
            try {
                WarCard card = player1Hand.remove(player1Hand.size() - 1);
                player2Hand.add(card);
            } catch (NullPointerException e) {
                self.declareWinner();
            }
        }

    }
    public void player1Draw3Cards(){
        for(int i=0 ; i <3 ; i++){
            WarCard card1;
            try {
                card1 = player1Hand.get(0);
                player1Hand.remove(0);
                getPlayer1War().add(card1);
            } catch (NullPointerException e) {
                self.declareWinner();
            }

        }
    }
    public void player2Draw3Cards(){
        for(int i=0 ; i <3 ; i++) {
            WarCard card2;
            try {
                card2 = player2Hand.get(0);
                player2Hand.remove(0);
                getPlayer2War().add(card2);
            } catch (NullPointerException e) {
                self.declareWinner();
            }
        }
    }
    public void warWinner(int playerNum){
        if(playerNum == 1) {
            getPlayer2War().forEach((n) -> getPlayer1Hand().add(n));
        }
        if(playerNum == 2) {
            getPlayer1War().forEach((n) -> getPlayer2Hand().add(n));
        }
    }

    public WarCard flipCard(int playerNum){
        if(playerNum == 1) {
            return getPlayer1Hand().get(0);
        }
        else if(playerNum == 2){
            return getPlayer2Hand().get(0);
        }
        return null;
    }



}


