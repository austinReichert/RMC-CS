package Lab3;

//Austin Reichert
//October 5th, 2019
//Collaborators: None.

import java.util.Scanner;
//Imports the scanner tool.

public class primes {
    //Java class.
    public static void main(String[] args) {
        //This is where the code goes.

        Scanner scan = new Scanner(System.in);
        //Recalls scanner.

        System.out.println("Type in a number to find all primes beneath it until 1.");
        int upperNum = scan.nextInt();
        //Scans for user input.
        //'upperNum' is the upper boundary
        int num = 2;
        //'num' starts at 2.
        int cnum = 2;

        if(upperNum <= 1){
            System.out.println("No prime numbers."); }
        //Tests if the users input is or below than 1. If true prints out message and ends program.

        System.out.println("");

        while(upperNum >= num) {
            //"While 'num' is less than or equal to 'upperNum'"...

            if(num == 2 || num == 3 || num == 5 || num == 7 || num == 11 || num == 13){
                System.out.println(num);    }
            //Checks if 2, 3, 5, 7, 11, or 13 is 'num'. If true prints number and adds 1 to 'num'.
            else{
                while(cnum <= 13){

                    if(num%cnum==0){
                    System.out.print("");
                cnum = cnum + 90;}
                //Adds BIG number to 'ccnum' so loop immediately ends.

                if(cnum == 2){
                    cnum = cnum + 1; }
                else{ cnum = cnum + 2;}
                }}
            //Tests if 'num' has a remainder when divided by 3, 5, 7, 11, 9, and 13. If it isn't then is printed (PRIME NUMBER).

            if(cnum == 15){
                System.out.println(num); }
            //Tests if the last loop was ended preemptively or not. If not, is a prime number.

            num = num + 1;
            cnum = 2;
            //Updates variables.
        }
    }}