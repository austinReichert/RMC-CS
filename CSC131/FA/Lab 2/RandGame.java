package Lab2;
//Austin Reichert
//September 25th, 2019
//Collaborators: No-one.

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Random;
//Imports the Random tool.


public class RandGame {
    //java class
    public static void main(String[] args) {
        //This is where the code goes.

        Random rand = new Random();
        //Recalls Random tool.

        int startP1 = rand.nextInt(10 + 1);
        int startP2 = rand.nextInt(10 + 1);
        //Line 20 and 21 are starting values (1-10)
        int stopP1 = rand.nextInt(50 + 1);
        int stopP2 = rand.nextInt(50 + 1);
        //Line 23 and 24 are stopping values (1-50)
        int stepP1 = rand.nextInt(10 + 1);
        int stepP2 = rand.nextInt(10 + 1);
        //Line 26 and 27 are stepping values (1-10)
        int sumP1 = 0;
        int sumP2 = 0;
        //Line 29 and 30 are the sums.

        System.out.println("Player 1:" + "(" + startP1 + ", " + stopP1 + ", " + stepP1 + ")" + "    Player 2:" + "(" + startP2 + ", " + stopP2 + ", " + stepP2 + ")");
        //Prints original numbers for both players.

        if(stepP1 != 0) {
            //"If player 1s stepping value is zero..."

            while (startP1 < stopP1) {
                //"If player 1s starting value is less than the stopping value..."
                sumP1 = startP1 + sumP1;
                startP1 = startP1 + stepP1; }}
            //The two lines above add the count for player 1 to the starting number and saves it in sum.

        else{ sumP1 = 0; }
        //If else statement is true, skips process and makes player 1s sum 0.

        if(stepP2 != 0) {
            //"If player 2s stepping value is zero..."

            while (startP2 < stopP2) {
                //"If player 2s starting value is less than the stopping value..."
                sumP2 = startP2 + sumP2;
                startP2 = startP2 + stepP2; }}
        else{ sumP2 = 0; }
        //If else statement is true, skips process and makes player 2s sum 0.

        System.out.println("Player 1: " + sumP1);
        System.out.println("Player 2: " + sumP2);
        //Displays the sums calculated in the while loops above.

        if(sumP1 == sumP2){
            System.out.println("Player 1 and 2 tie!"); }
        //"If player 1s sum is equal to player 2s sum than..."
        else{
        if(sumP1 > sumP2){
            //"If player 1s sum is greater than player 2s sum then..."
            System.out.println("Player 1 wins!"); }
            //"...do this if the statement above is false."
            else{ System.out.println("Player 2 wins!"); }}

        }}