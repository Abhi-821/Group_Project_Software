# War Card Game

This is a Java project for the classic card game War. The purpose of the game is for two players to compete to see who can win all of the cards in the deck.

## Object-Oriented Programming Principles

This project utilizes the following Object-Oriented Programming (OOP) principles:

- **Encapsulation**: The classes in this project are designed to hide internal details of their implementations from the outside world, and only expose the necessary interfaces for other classes to interact with them.

- **Inheritance**: The `Card` and `Deck` classes inherit from the `Suit` and `Rank` classes, respectively.

- **Polymorphism**: The `Player` class can be instantiated as either a human or a CPU player, and the `playCard` method in the `Game` class can handle either type of player.

## Classes

This project is divided into several classes, each with its own functionality:

- `Card`: Represents a single playing card with a suit and rank.
- `Suit`: Represents the four suits in a deck of cards.
- `Rank`: Represents the ranks of the cards in a deck.
- `Deck`: Represents a deck of cards, with methods for shuffling and dealing.
- `Player`: Represents a player in the game, with the ability to play cards and keep track of their hand.
- `Game`: Controls the flow of the game, including dealing cards, determining winners, and handling ties.

## Usage

To run this game:

1. Open a Java IDE (such as Eclipse or IntelliJ).
2. Open the `Game.java` file located in the `src` folder.
3. Click on "Run" to start the game.
4. Follow the on-screen instructions to play the game.


## Contact

If you have any questions or feedback, please contact abhiisharma08@gmail.com 
