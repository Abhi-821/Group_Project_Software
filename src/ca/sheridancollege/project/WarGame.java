package ca.sheridancollege.project;

import java.util.Scanner;
/*
@Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
Description: this is the view class that that does all user interaction
 */
public class WarGame extends Game{
    //these fields hold values a players current cards
    private WarCard player1Card;
    private WarCard player2Card;
    //variable play is used to take user input and decision
    private static int command;
    //instenses of War player
    WarPlayer player1;
    WarPlayer player2;

    Scanner input = new Scanner(System.in);
    public WarGame(){
        super("War");
    }

    //main method responsible for calling other methods
    public static void main(String[] args){
        //create a deck
        Deck.createDeck();
        Scanner input = new Scanner(System.in);
        System.out.println();
        //get user input
        System.out.println("Enter 1 to Start the game Enter 2 to display instructions");
        try {
            command = input.nextInt();
            if (command == 0) {
                //exit game
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (command == 2) {
                //print instructions
                Instructions.PrintInstructions();
            } else if (command == 1) {
                //play game
                WarGame interaction = new WarGame();
                interaction.play();
            } else {
                //prompt till user enters right input
                while (command != 1 || command != 2) {
                    System.out.println("Wrong input try again");
                    while (command != 1) {
                        command = input.nextInt();
                    }
                }
            }
            //if user enters wrong input
        }catch (Exception e){
            System.out.println("invalid input try again");
            command = input.nextInt();
        }
    }
    //the method that calls other methods and plays the game.
    public void play(){
        //registering player1
        System.out.println("Enter the first player's name");
        player1 = new WarPlayer(input.nextLine());
        //dealing cards to both players
        CardDealer.dealCards();
        //player 1 takes the dealt cards
        player1.getHand();

        //registering player 2
        System.out.println("Enter the Second player's name");
        player2 = new WarPlayer(input.nextLine());
        //player 2 takes the dealt cards
        player2.getHand();

        //both players get arrays that can hold cards in case of war
        player2.setPlayer1War(player1.getPlayer1War());
        player1.setPlayer2War(player2.getPlayer2War());
        //welcome message
        System.out.println("Welcome! the Game has started, enter 0 at anytime to quit");
        System.out.println("Both Players have been assigned 26 cards!");
        System.out.println("---------------------------------------------------");

        int i = 1;
        //game continues till one player runs out of cards.
        try {
            while (player1.getPlayer1Hand().size() != 0 || player2.getPlayer2Hand().size() != 0) {

                System.out.println();
                System.out.println("Round " + i++);
                System.out.println("-----------");
                System.out.println();
                //getting user input
                System.out.println("Player1: " + player1.getName() + " enter 1 to play you card");
                try {
                    command = input.nextInt();
                    //exit game
                    if (command == 0) {
                        System.out.println("The game has been ended, see you later!");
                        System.exit(0);
                    } else if (command != 1) {
                        System.out.println("try again");
                        while (command != 1) {
                            command = input.nextInt();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("invalid input try again");
                    command = input.nextInt();
                }
                //if the player says 1 play card
                player1Card = player1.playCard(1);
                //show the card that the player played
                System.out.println("--------------------------------------------------");
                System.out.println(player1.getName() + " played:        " + player1Card);
                System.out.println("---------------------------------------------------");

                //getting user input
                System.out.println("Player2: " + player2.getName() + " enter 2  to play you card");
                try {
                    command = input.nextInt();
                    if (command == 0) {
                        System.out.println("The game has been ended, see you later!");
                        System.exit(0);
                    } else if (command != 2) {
                        System.out.println("try again");
                        while (command != 2) {
                            command = input.nextInt();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("invalid input try again");
                    command = input.nextInt();
                }

                //if the player enters 2 play their card
                player2Card = player2.playCard(2);
                System.out.println("--------------------------------------------------");
                System.out.println(player2.getName() + " played:        " + player2Card);
                System.out.println("--------------------------------------------------");
                System.out.println();

                //compare cards
                if (player1Card.compare(player2Card) == 1) {
                    //method call if  player one has higher card
                    player1HasHigherCard();
                } else if (player1Card.compare(player2Card) == -1) {
                    //method call if  player two has higher card
                    player2HasHigherCard();
                } else {
                    //method call if both have equal cards, the parameter indicated that war array should
                    //be cleared as this is not a recursive war
                    bothHaveEqualCards(true);
                }
                //print updated score: num of cards
                System.out.println();
                score();
            }
        }catch (IndexOutOfBoundsException e){
            //if no a player runs out of cards declare winner
            declareWinner();
        }

    }

    //if player1 has higher card
    public void player1HasHigherCard(){
        System.out.println("--------------------------------------------------");
        System.out.println("player1:    "+player1.getName()+ " has bigger card");
        System.out.println(player2.getName() + "'s card will be added to "+ player1.getName()+"'s cards");
        System.out.println("--------------------------------------------------");
        System.out.println();
        //call switch cards method to get card from player2
        player1.switchCards(1);
    }
    //if player2 has higher card
    public void player2HasHigherCard(){
        System.out.println("--------------------------------------------------");
        System.out.println("player2:    "+player2.getName()+ " has bigger card");
        System.out.println(player1.getName() + "'s card will be added to "+ player2.getName()+"'s cards");
        System.out.println("--------------------------------------------------");
        System.out.println();
        //call switch cards method to get card from player1
        player2.switchCards(2);
    }
    //if both have equal higher cards
    public void bothHaveEqualCards(boolean clear){
        System.out.println("both players played cards of same rank.");
        System.out.println(player1.getName()+ " played  "+  player1Card + "  " +
                player2.getName() +" played  "+ player2Card);
        System.out.println();
        System.out.println("------------------THE WAR HAS BEGIN !!!!!!-----------------");
        System.out.println();
        //getting user input
        System.out.println(player1.getName() + " please enter 1 to draw 3 cards from deck");
        try {
            command = input.nextInt();
            if (command == 0) {
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (command != 1) {
                System.out.println("try again");
                while (command != 1) {
                    command = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            command = input.nextInt();
        }
        //clear the war array and draw 3 cards
        player1.player1Draw3Cards(clear);
        System.out.println();
        System.out.println("three cards have been drawn from your deck and the first card has been flipped");
        System.out.println();
        //flip the first card of the three
        player1Card = player1.flipCard(1);
        System.out.println("---------" +player1.getName() + " has " + player1Card +"---------");
        System.out.println("");
        System.out.println("---------------------------------------------------");
        //user input
        System.out.println(player2.getName() + " please enter 2 to draw 3 cards from deck");
        try {
            command = input.nextInt();
            if (command == 0) {
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (command != 2) {
                System.out.println("try again");
                while (command != 2) {
                    command = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            command = input.nextInt();
        }
        //claer the war array and draw 3 cards
        player2.player2Draw3Cards(clear);
        System.out.println("");
        System.out.println("three cards have been drawn from your deck and the first one has been flipped");
        System.out.println("");
        //flip first card of three
        player2Card = player2.flipCard(2);
        System.out.println("---------" +player2.getName() + " has " + player2Card +"---------" );

        //compare the first cards and declare winner
        if(player1Card.compare(player2Card) == 1){
            System.out.println("WAR WINNER: " + player1.getName() + " has bigger card; they get all 3 cards of player2 "+
                    player2.getName());
            player1.warWinner(1);
        } else if (player1Card.compare(player2Card) == -1) {
            System.out.println("WAR WINNER: " + player2.getName() + " has bigger card; they get all 3 cards of player1 "+
                    player1.getName());
            player2.warWinner(2);
        }else{
            System.out.println("Another War has begun");
            //recursive war has began therefore keep the previous three cards and repeat the war steps
            bothHaveEqualCards(false);
        }
    }
    //to display score at all times
    public void score(){
        System.out.println("player1 "+ player1.getName() + " has " + player1.getPlayer1Hand().size() + " cards");
        System.out.println("player2 "+ player2.getName() + " has " + player2.getPlayer2Hand().size() + " cards");
    }

    //to declare a winner
    public void declareWinner(){
        System.out.println();
        System.out.println("-------------------------------------------------------");
        if(player1 == null || player1.getPlayer2Hand().size() == 0){
            System.out.println("--------------player2 has won this game!---------------");
        } else if (player2 == null || player2.getPlayer2Hand().size() == 0) {
            System.out.println("--------------player1 has won this game!---------------");
        } else if (player1.getPlayer1Hand().size() < 3) {
            System.out.println("Sorry player 1: "+player1.getName()+" has insufficient cards to play on "+'\n'+
                    "player2 : " + player2.getName() + " has won this game!");
        } else if (player1.getPlayer2Hand().size() < 3) {
            System.out.println("Sorry player 2: "+player2.getName()+" has insufficient cards to play on "+'\n'+
                    "player1 : " + player1.getName() + " has won this game!");
        }
        System.out.println("-------------------------------------------------------");
        System.out.println();
        System.out.println("Enter 1 to play again.");
        System.out.println("Enter 0 to end game.");
        try {
            command = input.nextInt();
            if(command == 0){
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (command == 1) {
                play();
            }else {
                while (command != 1 | command !=0){
                    System.out.println("Enter 1 to play again, Enter 0 to end game:");
                    command = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            command = input.nextInt();
        }
    }
}
