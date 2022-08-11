package ca.sheridancollege.project;
import java.util.*;

public class WarGameView {
    public static String name1;
    public static String name2;
    public static int play;
    public static int command;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 to Start the game Enter 2 to display instructions");
        command = input.nextInt();
        if(command == 2){
            Instructions.PrintInstructions();
        }
        else if(command == 1){
            gameInteraction();
        }
        else{
            while(command != 1 || command != 2) {
                System.out.println("Wrong input try again");
            }
        }
    }
    public static void gameInteraction(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first player's name");
        name1 = input.nextLine();

        System.out.println("Enter the Second player's name");
        name2 = input.nextLine();

        System.out.println("Both Players have been assigned 26 cards");

        for(int i =1 ; i<= 52 ; i++) {
            if(i % 2 != 0) {
                System.out.println("Player1: " +  name1 + " enter 1 to play you card");
                play = input.nextInt();

                if(play ==1){
                    Player1.playCard();
                }
                else{
                    while(play != 1) {
                        System.out.println("Wrong input try again");
                        play = input.nextInt();
                    }
                }
            }
            else if(i % 2 == 0) {
                System.out.println("Player2: " +  name2 + " enter 2  to play you card");
                play = input.nextInt();

                if(play ==2){
                    Player2.playCard();
                }
                else{
                    while(play != 2) {
                        System.out.println("Wrong input try again");
                        play = input.nextInt();
                    }
                }

            }
        }
    }

}
