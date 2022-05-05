package Lab3;

//Austin Reichert
//October 4th, 2019
//Collaborators: none.

//Note: There's a weird bug with big numbers I don't know how to fix (or WHY it is there [ *or if its just my computer* ]).
//Example: Input 900, number 734 turns into 1222 and does some weird math on that line.

import java.util.Scanner;
//Imports the scanner tool.

public class MultiplicationTable {
    //Java class.
    public static void main(String[] args) {
        //This is where the code goes.

        Scanner scan = new Scanner(System.in);
        //Recalls Scanner.

        System.out.println("Type a whole positive number to create a multiplication table.");
        int num = scan.nextInt();
        //Scans for user input.

        int a = 1;
        //'a' is a counter variable that is involved in the calculation of the same line print (explained below line).
        int b = 0;
        //'b' is the variable that holds the answer to a*c and determines how many spaces there are between each number.
        int c = 1;
        //'c' is another counter variable that is involved in the calculation of the same line print (explained below line).
        int numNum = 0;
        //'numNum' is the variable that calculates how many spaces there will be using the equation it is in below.
        int space = 0;
        //'space' says how much space there is, keeps that amount.
        int sspace = 0;
        //'sspace' says how much space there is, this amount is altered and goes off of 'space'.

        int eenum = 0;
        //'eenum' is a counter used if the user inputs an incorrect input. (Ex: negatives or zero.)
        if(num <= 0){
            while (eenum < 5){ eenum = eenum + 1;
                //Counter! 'eenum' is zero and goes up to 100 if it isnt stopped.
                System.out.println("NEGATIVE NUMBERS AND 0 DO NOT WORK! TRY AGAIN!");
                if (eenum > 5){
                    System.out.println("");
                    System.out.println("Ending Program, try again using a positive number.");
                    break;  }}}
        //if-while-if code above spams the user with the first print, then the second and ends the program.

        System.out.println("");
        //Makes a small space to keep the input and the output apart.
        numNum = num * num;
        //Says 'numNum' is equal to 'num' (user input) * 'num' (user input)

        while(numNum > 0){
            numNum = numNum / 10;
            space = space + 1;  }
        //Calculates the spaces needed by dividing the product of 'numNum' of ten until it reaches zero.
        //Ex: 144 (space = 0) -> 14 (space = 1) -> 1 (space = 2) -> 0 (space = 3)[end].

           while(c <= num){
               a = 1;
               b = 0;
               //Resets variables for 'a' (row) and b (equation answer).

               while(a < num + 1){
                   sspace = space + 1;
                   //'sspace' is + 1 to assure every number has at LEAST 1 space.
                   b = a * c;
                   //C holds the 'row' number (ex: R1...R2...R3...) A holds the 'column' number (ex: R1... 1,2,3,4... R2... 2,4,6,8...)
                   //B is the equation (and what is printed for the multiplication table).

                   System.out.print(b);
                   //Only goes to 999999999 due to to integer size.

                   while(b > 0){
                       b = b / 10;
                       sspace = sspace - 1; }
                   //Calculates how many spaces are between each number DICTATED by 'b'.

                   while(sspace > 0){
                       System.out.print(" ");
                       sspace = sspace - 1;}
                   //Based on if statements above prints spaces.

                   a = a + 1;   }
               //Increases the number for 'a' (row number).

               c = c + 1;
               //Increases the number for 'c' (column number).
               System.out.println("");
               //Starts new line.
           }}}

           /* On 10/6/19 (12:03 AM) I was able to optimize my code from...

           if(b > 999999999){   sspace = sspace - 1; }
                   if(b > 99999999){   sspace = sspace - 1; }
                   if(b > 9999999){   sspace = sspace - 1; }
                   if(b > 999999){   sspace = sspace - 1; }
                   if(b > 99999){   sspace = sspace - 1; }
                   if(b > 9999){   sspace = sspace - 1; }
                   if(b > 999){   sspace = sspace - 1; }
                   if(b > 99){   sspace = sspace - 1; }
                   if(b > 9){   sspace = sspace - 1; }
                   if(b > 0){   sspace = sspace - 1; }

                   to...

                   while(b > 0){
                   b = b / 10;
                   sspace = sspace - 1; }

            */