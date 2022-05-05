package Lab9;

// Austin Reichert
// 11/25/19
// Collaborators: Consulted with Chris Cain.

public class Card{ //class

    private int suit; //field {Heart, Club, Spade, Diamond}
    private int value; //field {Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King}

    public Card(int suit, int value){
        this.suit = suit;
        this.value = value; } //constructor

    public String toString(){ //Prints a card based on the suit/value.
    String s = "";
    if(this.value == 1){ s+= "Ace"; }  //sets the value of value based on its numeric value (1 = ace)
       else if(this.value == 11){ s+= "Jack"; }   //sets the value of value based on its numeric value (11 = jack)
       else if(this.value == 12){ s+= "Queen"; }  //sets the value of value based on its numeric value (12 = queen)
       else if(this.value == 13){ s+= "King"; }   //sets the value of value based on its numeric value (13 = king)
       else{ s+= this.value; }   //sets the value of value based on its numeric value (# = #)

       s+=  " of "; // value of suit

        if(this.suit == 0){ s+= "Hearts"; }  //sets the value of suit based on its numeric value (0 = hearts)
        else if(this.suit == 1){ s+= "Clubs"; }   //sets the value of suit based on its numeric value (1 = clubs)
        else if(this.suit == 2){ s+= "Spades"; }   //sets the value of suit based on its numeric value (2 = spades)
        else if(this.suit == 3){ s+= "Diamonds"; }   //sets the value of suit based on its numeric value (3 = diamonds)

        return s; }

    public int getSuit() { return suit; } //getter
    public int getValue() { return value; } //getter
}

//Ignore the comments below, these are for me and my learning purposes!!!

//s+= adds to string. [ex: s = "Hi" -> s+= " my name is Austin." => s = "Hi my name is Austin."
//s+= is basically s = s + ""
// \n is new line character [for each loop]