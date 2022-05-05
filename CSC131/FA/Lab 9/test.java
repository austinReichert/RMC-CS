package Lab9;

// Austin Reichert
// 11/25/19
// Collaborators: Consulted with Chris Cain.

import java.util.InputMismatchException;
import java.util.Scanner;
//imports stuff for me to use

public class test {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in); //lets me use scanner
        int num = 0; //number editable by user through console. Controls simulation.
        Deck d = new Deck(); //makes a new deck

        int loop = 0; //number editable by programmer. Controls loop (loop directions not specified.)
        while(loop > 0){
            d.shuffleDeck(); //shuffles deck
            Hand h = new Hand(d); //makes new hand
            //System.out.println(h.toString()); //prints current hand for ease of use (uncomment to use)
            //{left line above commented as it was not specified to have the normal hand printed, but it might be nice to have].
            System.out.println(PrintPokerHand(h)); //function.
            System.out.println("");
            loop--;}

        while(num == 0){
        System.out.println("Please enter a number of simulations:");
        try{num = scan.nextInt();} //makes sure nothing incorrect is entered.
        catch(InputMismatchException le){
            System.out.println("Invalid input!"); //tells user what they did wrong
        num = 0; //does not let user escape this loop
        scan.nextLine();} //clears last line
        if(num < 0){
            System.out.println("No negatives!");
            num = 0; } } //makes sure the user doesnt input a negative.

        //I PURPOSELY did not make a cap to num. The max I have gotten without my computer throwing a fit is 10,000,000.

        d.shuffleDeck(); //shuffles
        Hand h = new Hand(d); //makes new deck
        System.out.println(h.Simulate(num)); //uses method to print results of simulation.
    }

    public static String PrintPokerHand(Hand h){ //function purpose described below.
            if(h.isRoyalFlush() == true){ return "Royal Flush"; }
            else if(h.isStraightFlush() == true){ return "Straight Flush"; }
            else if(h.isFourOfAKind() == true){return "Four of a Kind";}
            else if(h.isFullHouse() == true){return "Full House";}
            else if(h.isFlush() == true){return "Flush";}
            else if(h.isStraight() == true){return "Straight";}
            else if(h.isThreeOfAKind() == true){return "Three of a Kind";}
            else if(h.isTwoPair() == true){return "Two Pairs";}
            else if(h.isPair() == true){return "Pair";}
            else{ return "Nothing"; }}
            //Checks if the hand is something. If it is, prints so. Else, prints nothing.

//Within a loop, shuffle the deck, draw a hand, and call a function that takes a hand as input and returns which poker hand it is
// (by calling the appropriate methods in the hand class).
    //THATS WHAT THE FUNCTION ABOVE DOES^^
    //If thats not what was suppose to do, I tried to interpret the directions to the best of my abilities. Sorry!
}