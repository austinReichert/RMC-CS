package Lab9;

// Austin Reichert
// 11/25/19
// Collaborators: Consulted with Chris Cain.

import java.util.ArrayList; //imports array list

public class Hand { //class

    private ArrayList<Card> hand; //makes my hand array

    public Hand(Deck d){ //Deck is in here so I can get the card (at that index)
    hand = new ArrayList<Card>(); //lets me use deck
    int i = 0; //counter
    for(i = 0; i<5; i++){ hand.add(d.getCard(i)); } } //uses the getCard method to add a card to the hand.

    public String toString(){
        String s = "";
        for(Card h : hand){ s+= h.toString()+"\n"; } //Goes through the hand array and prints it out.
        return s; }

    public void sortHandByValue(){
        int i = 0; int j = 1; //counters. j is card counter
        Card temp; //makes a temp card without allocating memory

            while(i < 4){
        i=0; j=0; //resets variables if i is still less then 4
        while(j < 4){
        if(hand.get(j).getValue() > hand.get(j+1).getValue()){ //if the card at j is greater then the card at j+1
            temp = hand.get(j+1); //saves the next card
            hand.set(j+1,hand.get(j)); //sets the indexed card on next slot
            hand.set(j,temp);   } //sets the temp card on index

        else if(hand.get(j).getValue() <= hand.get(j+1).getValue()){ i++; }
            //if the card at j is less then or equal the card at j+1, adds 1 to i (I keeps this going until sorted)
            j++; } } }

        public Boolean isFlush(){
        Boolean TF = false; //variable used to hold and print end result
        int sameSuit = 0; //keeps track of cards with similar suits.
        int i=0; int j=0; //counters (i is used as index)
        sortHandByValue(); //sorts hand by value

        while(j<4){ //goes through suit
            i = 0;
        while(i<5){ //checks each card of the hand
            if(hand.get(i).getSuit() == j){ sameSuit++; } //if the card is the same suit as j, adds to sameSuit.
            i++; }

            if(sameSuit == 5){ //if there are 5 of the same suit, then it is a flush.
                TF = true;
                break; }
            else{ sameSuit = 0; } //resets sameSuit for next loop.
            j++; }
        return TF; }

    public Boolean isStraight(){
        Boolean TF = false; //variable used to hold and print end result
        int str=0; int storeValue=0; //str dictates if it is a straight. storeValue... you know.. stores a value...
        int i=4; //counter (used as index variable)
        sortHandByValue(); //sorts hand by value

        while(i >= 0){

            if(i != 0){
            storeValue = hand.get(i).getValue();
            if(hand.get(i-1).getValue() == storeValue-1){ str++; }
            //if the card at i is one less (in value) then the card at i+1, add 1 to str.
            i--; }
        else{ str++; i--; }} //cant check below the 0th index, so adds one to str and minus one from counter.
        if(str == 5){ TF = true; } //if str is 5, the cards are a straight.
        return TF; }

        public Boolean isStraightFlush(){
        if(isStraight() && isFlush()){ return true; }
        else{ return false; } }
        //if the hand is both a flush and a straight then this is true.

        public Boolean isPair(){
        Boolean TF =false;
        int i = 0; int j = 0; //counter (i is for index)
        int pair = 0; //keeps track of pairs
        sortHandByValue(); //sorts my hand again

        while(j < 14){ //goes through each type of card
            i=0;  //counter
            pair = 0; //keeps track of pairs
            while(i < 5){
                if(hand.get(i).getValue() == j){ pair++; } //if the card at index is j, adds 1 to pair.
                i++; }
            j++;
            if(pair == 2){ TF = true; break; }} //if there is a pair then TF is true.
        return TF; }

    public Boolean isFourOfAKind(){
        Boolean TF =false; //variable used to hold and print end result
        int i = 0; int j = 0; //counter (i is for index)
        int kind = 0; //keeps track of 'kinds'
        sortHandByValue(); //sorts my hand again

        while(j < 14){ //goes through each type of card
            i=0;  //counter
            kind = 0; //keeps track of 'kinds'
            while(i < 5){
                if(hand.get(i).getValue() == j){ kind++; } //if the card at index is j, adds 1 to kind.
                i++; }
            j++;
            if(kind == 4){ TF = true; break; }} //if there is a four of a kind then TF is true.
        return TF; }

    public Boolean isThreeOfAKind(){
        Boolean TF =false; //variable used to hold and print end result
        int i = 0; int j = 0; //counter (i is for index)
        int kind = 0; //keeps track of 'kinds'
        sortHandByValue(); //sorts my hand again

        while(j < 14){ //goes through each type of card
            i=0;  //counter
            kind = 0; //keeps track of 'kinds'
            while(i < 5){
                if(hand.get(i).getValue() == j){ kind++; } //if the card at index is j, adds 1 to kind.
                i++; }
            j++;
            if(kind == 3){ TF = true; break; }} //if there is a three of a kind then TF is true.
        return TF; }

    public Boolean isTwoPair(){
        Boolean TF = false;
        int i = 0; int j = 0; //counter (i is for index)
        int pair = 0; //keeps track of pairs
        sortHandByValue(); //sorts my hand again
        int store=0;

        while(j < 14){ //goes through each type of card
            i=0;  //counter
            pair = 0; //keeps track of pairs
            while(i < 5){
                if(hand.get(i).getValue() == j){ pair++;
                store = hand.get(i).getValue(); } //if the card at index is j, adds 1 to pair. Stores number of pair.
                i++; }
            j++;
            if(pair == 2){ break; }} //if there is a pair, breaks from loop.

        if(pair == 2){ //if the previous loop resulted in pair = 2, goes to this loop.
            pair = 0;
            j=0; i=0; //resets values to do it again.

            while(j < 14){ //goes through each type of card
                i=0;  //counter
                pair = 0; //keeps track of pairs
                while(i < 5){
                    if(hand.get(i).getValue() == j && hand.get(i).getValue() != store){ pair++;}
                    //if the card at index is j, AND IS NOT STORE, adds 1 to pair.
                    i++; }
                j++;
                if(pair == 2){ TF = true; break; } } } //if this pair is true, then its a 2 pair.
        else{TF = false; }
        return TF; }

    public Boolean isFullHouse(){
        if(isThreeOfAKind() == true && isPair() == true){ return true; }
        else{ return false; } } //if theres both a three of a kind and a pair, this exists.

    public Boolean isRoyalFlush(){
        Boolean TF = false; //variable used to hold and print end result
        int isRoyal=0; //stores the value that dictates whether the hand is a royal flush or not.
        int i=0; int j=0; //counters. (i is usually index)
        sortHandByValue(); //sorts hand

        if(isFlush() == true){ //if there is a flush, continues to check values.
        if(hand.get(i).getValue() == 1){isRoyal++;} //tests if index is 1
        i++;
        if(hand.get(i).getValue() == 10){isRoyal++;} //tests if index is 10
        i++;
        if(hand.get(i).getValue() == 11){isRoyal++;} //tests if index is 11
        i++;
        if(hand.get(i).getValue() == 12){isRoyal++;} //tests if index is 12
        i++;
        if(hand.get(i).getValue() == 13){isRoyal++;} //tests if index is 13

        if(isRoyal == 5){ TF = true; } //if isRoyal is 5, that means that it is a royal flush.
        else{TF = false; } }
        return TF; }

        public String Simulate(double num){
        String s = "";
        double dupenum = num;//Saves the amount of times ran through.
        double R=0; double SF=0; double FoK=0; double FH=0;
        double Fl=0; double Str=0; double ToK=0; double TP=0; double P=0;
        double N=0;
       //all of the variables above hold amount of times that particular hand occurs.

            Deck d = new Deck(); //makes a deck for this simulation.

        while(num > 0){
            d.shuffleDeck(); //shuffles deck
            Hand ha = new Hand(d); //makes new hand each time
            if(ha.isRoyalFlush() == true){ R++; } //R is royal flush
            else if(ha.isStraightFlush() == true){ SF++; } //SF is straight flush
            else if(ha.isFourOfAKind() == true){FoK++;} //Fok is four of a kind
            else if(ha.isFullHouse() == true){FH++;} //FH is full house
            else if(ha.isFlush() == true){Fl++;} //Fl is flush
            else if(ha.isStraight() == true){Str++;} //Str is straight
            else if(ha.isThreeOfAKind() == true){ToK++;} //Tok is three of a kind
            else if(ha.isTwoPair() == true){TP++;} //TP is two pairs
            else if(ha.isPair() == true){P++;} //P is pair
            else{N++;} //N is nothing
            num--; }

        s+= "Royal Flush: " + ((R/dupenum)*100) + "%" + "\n";
        s+= "Straight Flush: " + ((SF/dupenum)*100) + "%" + "\n";
        s+= "Four of a Kind: " + ((FoK/dupenum)*100) + "%" + "\n";
        s+= "Full House: " + ((FH/dupenum)*100) + "%" + "\n";
        s+= "Flush: " + ((Fl/dupenum)*100) + "%" + "\n";
        s+= "Straight: " + ((Str/dupenum)*100) + "%" + "\n";
        s+= "Three of a Kind: " + ((ToK/dupenum)*100) + "%" + "\n";
        s+= "Two Pair: " + ((TP/dupenum)*100) + "%" + "\n";
        s+= "One Pair: " + ((P/dupenum)*100) + "%" + "\n";
        s+= "Nothing: " + ((N/dupenum)*100) + "%" + "\n";
        //Statements above calculate the probability ((hand/numberoftrials)*100)) and add them to 's', which prints them.
        return s;
        }

        }

//hand.set(whereat,whatcard);
//hand.get(i).getSuit();