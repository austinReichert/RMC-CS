package Lab7;

//Austin Reichert
//November 12, 2019 (Turned in 11/10/19)
//Collaborators: Tanner Steorts (tester)

import java.util.Scanner;
import java.util.InputMismatchException;
//Imports this stuff so I can use it

public class LifeOfCell { //java class

    static final int size = 12; //Keeps 'size' as 12. (GLOBAL VARIABLE)

    public static void main(String[] args) { //Main function

        Scanner scan = new Scanner(System.in); //Recalls scanner
        char[][] board = new char[size][size]; //Char [row][column]

        int row = 0; //row variable
        int column = 0; //column variable
        int pass = 0; //makes infinite loops until a correct variable is entered
        int end = 0; //Creates last infinite
        int test = 0; //variable used to make sure the user doesnt try to print an empty board
        int c1 = 0; int c2 = 0; //counter variables used to help make sure the user doesnt print an empty board.

        while (row < size){
            column = 0;
            while (column < size) {
                board[column][row] = '.';
                column++; }
            row++; }
        column = 0; row = 0;
        //Makes the whole board '.'

        while (end == 0) { //Infinite to the infinites, ends once user enters a negative.
            pass = 0;

            while (pass == 0) { //Infinite loop until correct/negative input
                System.out.println("");
                System.out.println("Type in a number for your row, 0-9. Enter a negative to finish entering points.");

                try { row = scan.nextInt(); }
                catch (InputMismatchException ep) {
                    row = 10;
                    scan.nextLine(); } //Does not let the loop end if input is incorrect.
                if (row > 9) { System.out.println("Invalid input!");
                    pass = 0; }
                if (row < 10) { pass++; } //If row is less then 10 ends loop, goes onto next loop.
                if (row < 0){ end++;
                    pass++; }} //Ends the loop if row is less then zero, does not go to next loop

            pass--; //Makes pass 0

            while (pass == 0) { //Infinite loop until negative or correct input is inputted.
                System.out.println("");
                System.out.println("Type in a number for your column, 0-9. Enter a negative to finish entering points.");
                try { column = scan.nextInt(); }
                catch (InputMismatchException ep) {
                    column = 10; //If the input is wrong then it makes the user stay in this loop.
                    scan.nextLine(); }
                if (column > 9) { System.out.println("Invalid input!");
                pass = 0; } //If column is above 9, it does not accept the input
                if (column < 10) { pass++; } //If column is less then 10, releases from loop
                if (column < 0) { end++;
                    pass++; }} //If column is less then 0, releases from loop and doesn't ask for second input.
            if (end == 0) { board[row+1][column+1] = '█'; }
            else { System.out.print(""); }
            if (end == 0) { PrintBoard(board);}

            if(end != 0){ //If user enters a negative, tests if the board is empty.
                test = 0; //Resets variables...
                c1 = 0;
                c2 = 0;
                while(c1 < size){
                    c2 = 0;
                    while(c2 < size){
                        if(board[c1][c2] == '█'){ test++; } //Tests if the board has any user inputs ('█'). If true, adds 1 to true.
                        c2++; }
                    c1++; }
                //nested loop goes through and checks all possible points the user can input to.

                if(test == 0){
                    end = 0;
                    System.out.println("Your board is empty!"); } } } //If 'test' is 0, makes user retry for a correct input.

        while(end != 0){ //Infinite loop based off previous loop, does not ever end. Lets user update the board to their hearts content.
            System.out.println("Enter anything to continue.");
            scan.nextLine();
            UpdateBoard(board);
            PrintBoard(board); } }

    public static void PrintBoard(char[][] array) { //function to print board
        int row = 1; int column = 1; //Char [row][column]

        while (row < 11) {
            System.out.println("");
            column = 1;
            while (column < 11) {
                if (column == 10) { System.out.print(array[row][column]); } //Prints the point on the board
                else { System.out.print(array[row][column] + " "); } //Also prints the point on the board, but with a space
                column++; }
            row++;}
        System.out.println("");}
        //Goes through and prints every value of the 2D array, with spaces.

    public static char[][] UpdateBoard (char[][] array) { //function to update board (check neighbor, updates with new info)
        int row = 1; int column = 1; //Char [row][column]
        int [][]narray = new int[12][12]; //int array meant to track number of neighbors.

        while(row < 11){ //Checks neighbors and tallies them if they are alive.
            column = 1;
            while(column < 11){
                if(array[row-1][column-1] == '█'){ narray[row][column]++; }
                if(array[row-1][column] == '█'){ narray[row][column]++; }
                if(array[row-1][column+1] == '█'){ narray[row][column]++; }
                //Checks the areas above (and to the right and left) the cell being checked for neighbors
                if(array[row][column-1] == '█'){ narray[row][column]++; }
                if(array[row][column+1] == '█'){ narray[row][column]++; }
                //Checks the areas beside the cell being checked for neighbors
                if(array[row+1][column-1] == '█'){ narray[row][column]++; }
                if(array[row+1][column] == '█'){ narray[row][column]++; }
                if(array[row+1][column+1] == '█'){ narray[row][column]++; }
                //Checks the areas below the cell being checked for neighbors.
                column++; }
            row++; }
        //Checks the neighbors, adds to my int array if '█' exists within a neighboring cell.

        row = 1;
        //Resets row

        while(row < 11){ //nested loop make a cell dead or alive, based on number of neighbors and if it is dead or alive.
            column = 1;
            while(column < 11){

                if(array[row][column] == '.'){ //DEAD
                    if(narray[row][column] < 3){ array[row][column] = '.'; }
                    //If the number of neighbors is less than 3, it remains dead.
                    else if(narray[row][column] == 3){ array[row][column] = '█'; }
                    //If the number of neighbors is 3, it comes alive.
                    else if(narray[row][column] > 3){ array[row][column] = '.'; } }
                //If the number of neighbors is greater than 3, it remains dead.

                else if(array[row][column] == '█'){ //ALIVE
                    if(narray[row][column] < 2){ array[row][column] = '.'; }
                    ////If the number of neighbors is less then 2, it dies.
                    else if(narray[row][column] == 2 || narray[row][column] == 3){ array[row][column] = '█'; }
                    //If the number of neighbors is 2 or 3, then it remains alive.
                    else if(narray[row][column] > 3){ array[row][column] = '.'; } }
                //If the number of neighbors is greater then 3, then it dies.
                column++; }
            row++; }
        return array; } }