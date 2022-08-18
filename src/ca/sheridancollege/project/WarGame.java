package ca.sheridancollege.project;

import java.util.Scanner;

public class WarGame extends Game{
    private WarCard player1Card;
    private WarCard player2Card;
    private static int play;
    private static int command;
    WarPlayer player1;
    WarPlayer player2;

    Scanner input = new Scanner(System.in);
    public WarGame(){
        super("War");
    }
    public void play(){
        System.out.println("Enter the first player's name");
        player1 = new WarPlayer(input.nextLine());
        CardDealer.dealCards();
        player1.getHand(1);

        System.out.println("Enter the Second player's name");
        player2 = new WarPlayer(input.nextLine());
        player2.getHand(2);
        player2.setPlayer1War(player1.getPlayer1War());
        player1.setPlayer2War(player2.getPlayer2War());
        System.out.println("Welcome! the Game has started, enter 0 at anytime to quit");
        System.out.println("Both Players have been assigned 26 cards!");
        System.out.println("---------------------------------------------------");

        int i = 1;
        while (player1.getPlayer1Hand().size() != 0 || player2.getPlayer2Hand().size() != 0){

                System.out.println();
                System.out.println("Round "+ i++);
                System.out.println("-----------");
                System.out.println();
                System.out.println("Player1: " + player1.getName() + " enter 1 to play you card");
                try {
                    play = input.nextInt();
                    if (play == 0) {
                        System.out.println("The game has been ended, see you later!");
                        System.exit(0);
                    } else if (play != 1) {
                        System.out.println("try again");
                        while (play != 1) {
                            play = input.nextInt();
                        }
                    }
                }catch (Exception e){
                    System.out.println("invalid input try again");
                    play = input.nextInt();
                }

                player1Card = player1.playCard(1);
                System.out.println("--------------------------------------------------");
                System.out.println(player1.getName() + " played:        "+player1Card);
                System.out.println("---------------------------------------------------");

                System.out.println("Player2: " + player2.getName() + " enter 2  to play you card");
                try {
                    play = input.nextInt();
                   if (play == 0) {
                       System.out.println("The game has been ended, see you later!");
                       System.exit(0);
                   } else if (play != 2) {
                       System.out.println("try again");
                       while (play != 2) {
                           play = input.nextInt();
                       }
                   }
                }catch (Exception e){
                    System.out.println("invalid input try again");
                    play = input.nextInt();
                }

                    player2Card= player2.playCard(2);
                    System.out.println("--------------------------------------------------");
                    System.out.println(player2.getName() + " played:        "+player2Card);
                    System.out.println("--------------------------------------------------");
                    System.out.println();

            if(player1Card.compare(player2Card) == 1){
                player1HasHigherCard();
            } else if (player1Card.compare(player2Card) == -1) {
                player2HasHigherCard();
            }else{
               bothHaveEqualCards(true);
            }
            System.out.println();
            score();
        }
        if(play == 0){
            System.out.println("Game Ended!");
        }
        declareWinner();
    }

    public void player1HasHigherCard(){
        System.out.println("--------------------------------------------------");
        System.out.println("player1:    "+player1.getName()+ " has bigger card");
        System.out.println(player2.getName() + "'s card will be added to "+ player1.getName()+"'s cards");
        System.out.println("--------------------------------------------------");
        System.out.println();
        player1.switchCards(1);
    }
    public void player2HasHigherCard(){
        System.out.println("--------------------------------------------------");
        System.out.println("player2:    "+player2.getName()+ " has bigger card");
        System.out.println(player1.getName() + "'s card will be added to "+ player2.getName()+"'s cards");
        System.out.println("--------------------------------------------------");
        System.out.println();
        player2.switchCards(2);
    }
    public void bothHaveEqualCards(boolean clear){
        System.out.println("both players played cards of same rank.");
        System.out.println(player1.getName()+ " played  "+  player1Card + "  " +
                player2.getName() +" played  "+ player2Card);
        System.out.println();
        System.out.println("------------------THE WAR HAS BEGIN !!!!!!-----------------");
        System.out.println();
        System.out.println(player1.getName() + " please enter 1 to draw 3 cards from deck");
        try {
            play = input.nextInt();
            if (play == 0) {
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (play != 1) {
                System.out.println("try again");
                while (play != 1) {
                    play = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            play = input.nextInt();
        }

        player1.player1Draw3Cards(clear);
        System.out.println("");
        System.out.println("three cards have been drawn from your deck and the first card has been flipped");
        player1Card = player1.flipCard(1);
        System.out.println(player1.getName() + " has " + player1Card);
        System.out.println("");
        System.out.println("---------------------------------------------------");
        System.out.println(player2.getName() + " please enter 2 to draw 3 cards from deck");
        try {
            play = input.nextInt();
            if (play == 0) {
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (play != 2) {
                System.out.println("try again");
                while (play != 2) {
                    play = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            play = input.nextInt();
        }
        player2.player2Draw3Cards(clear);
        System.out.println("");
        System.out.println("three cards have been drawn from your deck and the first one has been flipped");
        player2Card = player2.flipCard(2);
        System.out.println(player2.getName() + " has " + player2Card);

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
            bothHaveEqualCards(false);
        }
    }
    public void score(){
        System.out.println("player1 "+ player1.getName() + " has " + player1.getPlayer1Hand().size() + " cards");
        System.out.println("player2 "+ player2.getName() + " has " + player2.getPlayer2Hand().size() + " cards");
    }

    public static void main(String[] args){
        Deck.createDeck();
        Scanner input = new Scanner(System.in);
        System.out.println();
        System.out.println("Enter 1 to Start the game Enter 2 to display instructions");
        command = input.nextInt();
        if(command == 2){
            Instructions.PrintInstructions();
        }
        else if(command == 1){
            WarGame interaction = new WarGame();
            interaction.play();
        }
        else{
            while(command != 1 || command != 2) {
                System.out.println("Wrong input try again");
            }
        }
    }
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
            play = input.nextInt();
            if(play == 0){
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (play == 1) {
                play();
            }else {
                while (play != 1 | play !=0){
                    System.out.println("Enter 1 to play again, Enter 0 to end game:");
                    play = input.nextInt();
                }
            }
        }catch (Exception e){
            System.out.println("invalid input try again");
            play = input.nextInt();
        }
    }
}
