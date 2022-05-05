package Lab2;

//Austin Reichert
//September 24th, 2019
//Collaborators: None (no student testers + collaborators)

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Scanner;
//Imports the scanner tool.

public class Fibonacci {
    //java class
    public static void main(String[] args) {
        //This is where the code goes

        Scanner scan = new Scanner(System.in);
        //Recalls Scanner.

        System.out.println("Type in a whole number to get the Fibonacci Sequence until that number.");
        //Asks user to type in a whole number.
        int counter = scan.nextInt();
        //Determines how many times my code runs based on user input.

        int pnum = 0;
        //Previous number
        int num = 1;
        //Current number
        int snum = 0;
        //Sum of two numbers above.

        while(counter < 0){
            //"While the users input is below zero..."
            System.out.println("Enter a positive whole number or zero to continue.");
            //Asks the user to input a new term zero or above.
            counter = scan.nextInt(); }
        //Lines 32-36 do NOT let the user progress until they end the program or do as it says.

        if(counter == 0){
            //"If the users input is 0..."
            System.out.println("0 + 0 = 0.");
        }

        System.out.println("");
        //Blank space to keep the output looking clean.

        while(counter > 0){
            //"While the users input is above zero..."

            counter = counter - 1;
            //Tallies how many times the code has ran.

            System.out.println(num);
            //Prints out current number.
            snum = num + pnum;
            //Adds previous number and current number for the sum.
            pnum = num;
            //Makes the previous number equal the current number (updating for next interval).
            num = snum;
            //Makes the current number equal to the sum (updating for the next interval).
        }

    }}
