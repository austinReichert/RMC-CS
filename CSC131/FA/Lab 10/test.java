package Lab10;

// Austin Reichert
// 12/6/19
// Collaborators: Tanner Steorts (Tester)

import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int scale = -1; //scale variable
        String name = ""; //name variable
        Game g = new Game(); //makes a new game.

        while(scale < 0){ //this entire while loop makes sure scaling is between 0 and 1000000.
            System.out.println("");
            System.out.println("Enter an amount (in whole numbers) your enemies scales per battle. [0-1,000,000]");
            System.out.println("Scaling adds random additional points of a new enemy to all stats. ");
            System.out.println("(Each new enemy will scale by your level automatically!)");
            try{ scale = scan.nextInt(); }
            catch(InputMismatchException ea){
                scan.nextLine();
                scale = -1; }
            if(scale >= 0 && scale <= 1000000){ scale = scale; } //makes sure user is in correct range.
            else{ System.out.println("Invalid input!");
                scale = -1; } }
        scan.nextLine(); //clears last line

        g.SetScaling(scale); //sets scaling

        System.out.println("What would you like to be called? You cannot alter your name after setting it.");
        name = scan.nextLine();
        g.SetPlayerName(name); //asks the user for a name and sets it as so
        g.PlayGame();

    }
}