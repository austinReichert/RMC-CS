package Lab2;

//Austin Reichert
//September 24th, 2019
//Collaborators:

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Scanner;
//Imports the Scanner tool.

public class Palindrome {
    //java class
    public static void main(String[] args) {
        //This is where code goes

        Scanner scan = new Scanner(System.in);
        //Recalls Scanner.

        System.out.println("Type in a whole number to test if its a palindrome.");
        //Asks the user to type in a whole number to test.

        int num = scan.nextInt();
        //This variable holds the number being tested.
        int fillnum = num;
        //This variable allows the number being tested to be modified.
        int flipnum = 0;
        //This variable holds the number AFTER being flipped.

        System.out.println("");
        //Empty space to make the print cleaner... also keeps my code easier to read.

        if(num < 0){
            //"If num (user input) is less than 0..."
            num = num * -1;
            fillnum = num; }
        //Changes the negative to a positive and updates all variables associated to num.

        while(fillnum > 0){
            //"While fillnum (replacement for num) is greater than 0..."

            flipnum = flipnum * 10 + (fillnum%10);
            //Flips number by multiplying everything by 10 before adding the new number. (New number is taken from fillnum%10).
            //See line 56-67 for example.

            fillnum = fillnum/10;
            //Lops off the end of the number for the next loop. Also updates condition.
    }

        if(num == flipnum){ System.out.println("Palindrome!"); }

        else{ System.out.println("Not a Palindrome!"); }
        //Lines 50-52 tells user if or if not their number was a palindrome.
}}

/*
Example of my number flipping process...
Take 4324 for example. First it takes a 4 and adds it on.
1) 4
Then times that by 10 and add 2
2) 42
Then times that by 10 and add 3
3) 423
Then times that by 10 and add 4
4) 4234
Thus, flipped number!   Also, not a Palindrome.
 */