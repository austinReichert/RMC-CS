package Lab9;

// Austin Reichert
// 11/25/19
// Collaborators: Consulted with Chris Cain.

import java.util.ArrayList; //imports array list
import java.util.Random; //imports random for me

public class Deck { //class

    Random r = new Random(); //lets me use random as r

    private ArrayList<Card> cards; //makes my deck array

    public Deck(){ //makes deck
        cards = new ArrayList<Card>(); //arraylist
        int i; int j; //counter variables

        //CARD CONSTRUCTOR
        for(i = 0; i < 4; i++){ //nested for loop that does what the comment says below.
            for(j = 1; j < 14; j++){
                cards.add(new Card(i,j)); } } }//Uses card constructor to make a new card. Adds it to the deck

    public Card getCard(int index){ return cards.get(index); } //gets a card at an index

        public String toString(){
        String s = "";
        for(Card c : cards){ s+= c.toString()+"\n"; } //prints all the cards in the deck.
        return s; }

        public void shuffleDeck(){ //shuffles deck
        Card temp; //makes a temp card without allocating memory
        int randNum = 0; //makes a variable that stores the random number.
        int i=0; //counter

            for(Card c : cards){ //for else loop (goes through entire array)[for each card in hand...]

            randNum = r.nextInt((52-i))+i; //increases the lower bound so we do not continuously mix the same cards.
            temp = cards.get(randNum); //gets random card and saves i
            cards.set(randNum, cards.get(i)); //sets the random card to the card at first index.
            cards.set(i,temp); //sets the temp card at the index
            i++; } }
}