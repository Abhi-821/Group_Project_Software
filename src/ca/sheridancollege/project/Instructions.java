package ca.sheridancollege.project;
import java.util.Scanner;
/*
@Authors: Fizza Imran, Abhi Sharma, Sniya Hussain, Gurleen Singh.
Description: The view class responsible for printing out instructions.
 */
public class Instructions {
    public static void PrintInstructions(){
        int move;
        System.out.println("---------Welcome to Card Game: War---------");
        System.out.println();
        System.out.println("following are the rules of the game:");
        System.out.println();
        System.out.println();
        System.out.println("• A shuffled deck of cards in distributed between two players.\n" +
                "• The first player enters 1 to flip the first card.\n" +
                "• The second  player enters 2 to flip the first card.\n" +
                "• Whoever has the bigger card (only ranks are compared, suits are ignored) gets both cards.\n" +
                "• The highest card in this game is Ace followed by king, queen, jack, and all the way to 2.\n" +
                "• If both players flip a card that has same rank; war begins.\n" +
                "• Now player 1 enters 1 to withdrawn three cards and keep them face down\n" +
                "• Now player 2 enters 3 to withdrawn three cards and keep them face down\n" +
                "• The first cards of each 3 is then flipped (and displayed on console) the player who has higher\n" +
                "rank then takes all 6 cards.\n" +
                "• If players again get identical ranks another war begins, and 3 more cards are withdrawn and\n" +
                "kept face down on previous 3.\n" +
                "• The same procedure follows, and the first cards are flipped. The person with higher rank\n" +
                "then takes all 12 cards.\n" +
                "• If a person do not have enough cards during the war, he/she losses the game. \n" +
                "• This process continues till one player gets all 52 cards and wins. The person who runs out of\n" +
                "the cards first losses\n");
        System.out.println();
        System.out.println("Enter 1 to play the game");
        System.out.println("Enter 0 to quit");
        Scanner input = new Scanner(System.in);
        try {
            move = input.nextInt();
            if(move == 0){
                System.out.println("The game has been ended, see you later!");
                System.exit(0);
            } else if (move == 1) {
                WarGame game = new WarGame();
                game.play();
            }
        }catch (Exception e){
            System.out.println("invalid input, try again.");
            move = input.nextInt();
        }


    }
}
