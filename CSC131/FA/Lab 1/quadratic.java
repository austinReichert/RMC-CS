package Lab1;

//Austin Reichert
//September 12th, 2019
//Collaborators: Tanner Steorts

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Scanner;
//Imports the scanner tool

public class quadratic {
    //java class

    public static void main(String[] args) {
        //this is where code goes

        Scanner scan = new Scanner(System.in);
        //Recalls scanner.

        System.out.println("Type in the numbers for a, b, and c for the following formula: ax^2+bx+c");
        //Asks user to type in variables for this formula.

        double varA = scan.nextDouble();
        double varB = scan.nextDouble();
        double varC = scan.nextDouble();
        //Above lines search for information provided by user to input into formula.

        double QuadAnswer = (-varB + -Math.sqrt(Math.pow(varB, 2) - 4 * varA * varC )) / (2 * varA);
        //Formula

        double QuadAnswer2 = (-varB - -Math.sqrt(Math.pow(varB, 2) - 4 * varA * varC )) / (2 * varA);
        //Formula but checks for second root

        if (QuadAnswer == QuadAnswer2) {
            //Checks if there are two roots to the formula (if not, continues to check if there are roots.)

            if (QuadAnswer == 0) { System.out.println(QuadAnswer); }
           //Checks if QuadAnswer is zero.

            else if (QuadAnswer > 0) { System.out.println(QuadAnswer); }
            //Checks if QuadAnswer is above zero

            else if (QuadAnswer < 0) { System.out.println(QuadAnswer); }
            //Checks if QuadAnswer is below zero.

            else { System.out.println("No real roots."); }
            //Tells user there is no real roots.
        }

        else if(QuadAnswer2 < 0) { System.out.println(QuadAnswer + " and " + QuadAnswer2);}
        //Checks QuadAnswer2 is below zero.

        else if(QuadAnswer2 > 0) { System.out.println(QuadAnswer + " and " + QuadAnswer2);}
        //Checks if QuadAnswer2 is more than zero.

        else if(QuadAnswer2 == 0) { System.out.println(QuadAnswer + " and " + QuadAnswer2);}
        //Checks if QuadAnswer2 is zero.

        else { System.out.println("No real roots."); }
        //Tells user there is no real roots.

        }}
