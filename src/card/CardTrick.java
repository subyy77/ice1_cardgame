/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package card;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a magic hand of 7 cards with random Card Objects
 * and then asks the user to pick a card and searches the array of cards
 * for the match to the user's card. To be used as starting code in ICE 1
 * @author Subina Bohara 991764529
 */
public class CardTrick {
    
    public static void main(String[] args)
    {
        Card[] magicHand = new Card[7];
        Random random = new Random();
        
        for (int i=0; i<magicHand.length; i++)
        {
            Card c = new Card();
            c.setValue(random.nextInt(13) + 1);
            c.setSuit(Card.SUITS[random.nextInt(4)]);
            magicHand[i] = c;
            
            System.out.println("Card " + (i+1) + ": " + c.getValue() + " of " + c.getSuit());
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nPick a card, any card!");
        
        System.out.print("Enter card value (1-13, where 1=Ace, 11=Jack, 12=Queen, 13=King): ");
        int userValue = scanner.nextInt();
        
        System.out.println("Enter suit: ");
        System.out.println("1 for Hearts");
        System.out.println("2 for Diamonds");
        System.out.println("3 for Spades");
        System.out.println("4 for Clubs");
        System.out.print("Your choice: ");
        int suitChoice = scanner.nextInt();
        String userSuit = Card.SUITS[suitChoice - 1];
        
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(userSuit);
        
        System.out.println("\nYou selected: " + userCard.getValue() + " of " + userCard.getSuit());

        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        System.out.println("\nLucky Card: " + luckyCard.getValue() + " of " + luckyCard.getSuit());
        
        Card luckyCard = new Card();
        luckyCard.setValue(2);
        luckyCard.setSuit("Clubs");
        
        boolean found = false;
        for (Card card : magicHand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }
        
        boolean isLuckyCard = (userCard.getValue() == luckyCard.getValue() && 
                              userCard.getSuit().equals(luckyCard.getSuit()));
        
        if (found || isLuckyCard) {
            System.out.println("Congratulations! Your card is in the magic hand!");
            if (isLuckyCard) {
                System.out.println("You picked the lucky card (2 of Clubs)!");
            }
        } else {
            System.out.println("Sorry, your card is not in the magic hand.");
        }
        
        scanner.close();
    }
}
