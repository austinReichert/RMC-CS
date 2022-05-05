package Lab1;

//Austin Reichert
//September 11th, 2019
//Collaborators: Tanner Steorts

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Scanner;
//Imports the scanner tool

public class AbsoluteValue {
    //java class

    public static void main(String[] args) {
        //this is where the code goes

        Scanner scan = new Scanner(System.in);
        //Recalls scanner.

        System.out.println("Enter a number you would like to have in absolute value.");
        //Asks the user to type in a number to calculate absolute value

        double num = scan.nextDouble();
        //Looks for information provided by user

        if (num > 0) { System.out.println(num); }
        //Determines if the number is positive, if true, prints the number.

        else if (num == 0) { System.out.println(num); }
        //Determines if the number is zero, if true, prints zero.

        else { System.out.println((num - num) - num); }
        //Determines if the number is any number besides 0 and above. If is below 0, calculates absolute value.

    }}