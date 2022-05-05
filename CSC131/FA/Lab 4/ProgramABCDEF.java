package Lab4;

//Austin Reichert
//October 15, 2019
//Collaborators: None.

import java.util.InputMismatchException;
import java.util.Scanner;
//imports the Scanner tool.

public class ProgramABCDEF {

    //java class
    public static void main(String[] args) {
        //This is where the code goes.

        Scanner scan = new Scanner(System.in);
        //Recalls the scanner tool.

        int Infinity = 0;
        //This controls my infinite loop (not really but lets pretend it does).
        String input = "";
        //Main input for the menu.
        int number = 1;
        //This is the first input (fills array until number <= -1)
        int savearray = 0;
        //This is a counter variable ONLY used in c
        int index = 0;
        //Index variable for a and b.
        int ketch = 0;
        //Catch variable for numbers.
        int menu = 0;
        //This value determines if or if NOT the menu is presented.
        int element = 0;
        //Keeps count of how many same elements are in the array (c).
        int counter = 0;
        int copycounter = 0;
        //Counter variables.

        int[] num;
        num = new int[1000];
        //This is the array that holds all my stuff

        int[] numcopy;
        numcopy = new int[1000];
        //This is the array that helps with calculations

        System.out.println("Please enter a number to begin a list. Type in -1 or below to end the list.");

        while(number > -1){
            ketch = 0;
            try{ number = scan.nextInt(); }
            catch(InputMismatchException e){
                System.out.println("Invalid input! Try again!");
                scan.nextLine();
                System.out.println("");
            ketch = ketch + 1;}
            //The try-catch makes sure that the user does not break the code by inputting a bad input.
            //'ketch' makes sure that if the input was invalid that the input would not be saved as 1.
            if(counter > 999){ System.out.println("You have exceeded the maximum list amount [999]."); break;}
            //Breaks out of this loop if the user has inputted 999 numbers.
            if(number > -1){ System.out.println("Please enter a number (type in anything below 0 to end list)[maximum is 999]");
                num[counter] = number; }
            //While number is greater then -1, make the number inputted equal to that of the array.
            if(ketch == 1){
                System.out.print("");}
            //If ketch is equal to one, then do nothing. If false, adds 1 to the counter.
            else{ counter++;}}

        counter = counter - 1;
        //Subtracts 1 here to make sure that the statement above did not add any EXTRA numbers (usually 0)
        System.out.println("");

        while(copycounter < counter){
            numcopy[copycounter] = num[copycounter];
            copycounter++; }
        //Copies one array to the other.

        while(Infinity != 1){
            //Infinite time

            copycounter = 0;
            savearray = 0;
            element = 0;
            input = "";
            ketch = 0;
            menu = 0;
            index = 0;
            number = 0;
            //Resets the variables used in the infinite.

            while(input.equals("")){
                if(menu < 1){
                System.out.println("Please select the following by typing in the corresponding letter.");
                System.out.println("a. Insert a number given into the list at a specified position.");
                System.out.println("b. Delete an element at a given position.");
                System.out.println("c. Delete all instances of a given element.");
                System.out.println("d. Print the number of elements currently in the list.");
                System.out.println("e. Print the current list.");
                System.out.println("f. Exit the program.");
                menu++;}
                //Prints menu ONCE and ONLY once.
                try{ input = scan.nextLine();}
            catch(InputMismatchException ak){
                System.out.println("Invalid input!");
                input = scan.nextLine();}}
            //Catches mismatch inputs (ex: int instead of string)

            if(input.length() != 1){
                System.out.println("Invalid input!");
                System.out.println("");}
            //If the input isn't one character then it does not allow the user to select an option below.
            else{
            if(input.charAt(0)=='A'|| input.charAt(0)=='a') {
                if(counter > 999){
                    System.out.println("The list is already at maximum capacity!"); }
                else{
                if (counter < 1) {
                    System.out.println("Your list is currently empty.");
                    System.out.println("Try again after you filled your list!");
                    //Tests if there is anything in the list.
                    System.out.println(""); }
                else {
                    System.out.println("Please enter a number to add to the list.");
                    System.out.println("Type in anything but a number to return to the menu.");
                    //Asks the user to enter the number they want to add. Gives them the option to leave.
                    try {
                        number = scan.nextInt();
                    } catch (InputMismatchException i) {
                        System.out.println("Returning to menu...");
                        System.out.println("");
                        scan.nextLine();
                    }
                    //If the input is NOT an integer then the user is sent back to menu.
                    if (number < 0) {
                        System.out.println("Negative numbers cannot be inputted.");
                        System.out.println("");
                    } else {
                        System.out.println("Please enter the index at which you would like to insert it");
                        System.out.println("Type in anything but a number to return to the menu.");
                        //Asks the user to enter an index number. Gives them the option to leave.
                        try {
                            index = scan.nextInt(); }
                        catch (InputMismatchException i) {
                            System.out.println("Returning to menu...");
                            System.out.println("");
                            scan.nextLine(); }
                        //If the input is NOT an integer then the user is sent back to menu.
                        if (index > counter + 1 || index < 0) {
                            System.out.println("Sorry, your input is out of bounds!");
                            System.out.println(""); }
                        //If the index is greater then the counter(variable that stores how big the array is) it sends the user
                        //back to the menu.
                        else {
                            if (index > 0) {
                                System.out.println("Successfully added the number " + number + " to index " + index + ".");
                                System.out.println("");
                                copycounter = counter;
                                //Prints what its doing first BEFORE doing it.
                                while(copycounter > index - 1){
                                 num[copycounter] = numcopy[copycounter-1];
                                copycounter--; }
                                //basically copying the array but backwards until reaches index.
                                num[index - 1] = number;
                                numcopy = num;
                                counter++;
                            scan.nextLine();}
                                else{
                                    System.out.println("There is no 0th index.");
                                    System.out.println("");}
                            }}}}}
                //Resets the numbers to their NEW values found above.

                if(input.charAt(0)=='B'|| input.charAt(0)=='b'){
                if(counter < 1){ System.out.println("Your list is currently empty!");
                //Tests if there is anything in the list.
                    System.out.println(""); }
                else{
                System.out.println("Which index would you like to delete?");
                System.out.println("Type in anything but a number to return to the menu.");
                //Asks the user what they want to do. Give them the option to leave.
                try {index = scan.nextInt();}
                catch(InputMismatchException i){
                    System.out.println("Returning to menu...");
                    System.out.println("");
                    scan.nextLine();}
                //If the input is NOT an integer then the user is sent back to menu.
                if(index > counter || index < 0){ System.out.println("Sorry, your input is out of bounds!");
                    System.out.println("");}
                //If the index is greater then the counter(variable that stores how big the array is) it sends the user
                //back to the menu.
                else{
                if(index > 0){
                    System.out.println("Successfully deleted the number " + num[index - 1] + " from index " + index + ".");
                    System.out.println("");
                    //Prints what its doing first BEFORE doing it.
                while(index < counter){
                    num[index - 1] = numcopy[index];
                    index = index + 1; }
                //Moves everything BEYOND the index number to cover the number 'deleted'.
                numcopy = num;
                counter = counter - 1;}}}}
            //Resets the numbers to their NEW values found above.

            if(input.charAt(0)=='C'|| input.charAt(0)=='c') {
                copycounter = counter;
                if(counter < 1){
                    System.out.println("Your list is empty!");
                    System.out.println("");}
                else{
                    System.out.println("Which number would you like to delete?");
                    System.out.println("Type in anything but a number to return to the menu.");
                    //Asks the user what they want to do. Give them the option to leave.
                    try {number = scan.nextInt();}
                    catch(InputMismatchException ir){
                        System.out.println("Returning to menu...");
                        System.out.println("");
                        scan.nextLine();
                    ketch++;}
                    //If the input is NOT an integer then the user is sent back to menu.
                    if(ketch == 1){
                        System.out.println("");}
                    else{
                    while(copycounter > 0){
                        if(num[copycounter-1] == number){
                            element++;}
                        copycounter--; }
                    while(savearray < 1){
                        if(element < 2){ System.out.println("Removed " + element + " instances of the number " + number);
                            System.out.println("");}
                        if(element == 1){ System.out.println("Removed " + element + " instance of the number " + number);
                            System.out.println("");}
                        //Prints the result before removing number.
                        savearray++; }
                    copycounter = counter;
                    savearray = 0;
                    //Tests if the number is in the list.

                    if(element > 0){
                        copycounter = 0;
                        while(copycounter < counter){
                            if(num[copycounter]!= number){
                                numcopy[savearray] = num[copycounter];
                            savearray++;}
                            copycounter++; }
                        //Goes through the array and saves the numbers that arent the number the user wants to be deleted.
                            counter = counter - element;
                        num = numcopy;
                        //Resets numbers to NEW values.
                        }
                    else{
                        System.out.println("That number does not exist in the list!");
                        System.out.println("");}
                }}
            }

            if(input.charAt(0)=='D'|| input.charAt(0)=='d') {
                if(counter > 2){ System.out.println("There are currently " + counter + " elements in the list."); }
                else if(counter == 1){ System.out.println("There is currently " + counter + " element in the list."); }
                else if(counter == 0){System.out.println("There are currently no elements in the list."); }
                System.out.println("");}
            //Says how many elements are in the list based on the counter variable.

            if(input.charAt(0)=='E'|| input.charAt(0)=='e'){
                if(counter > 0){ System.out.print("Your current list is: ");
                System.out.print("{");
                while(copycounter < counter){
                    //While copycounter is less then counter. (copycounter STARTS at 0)
                    if(copycounter == counter - 1){ System.out.print(num[copycounter]); }
                    else{ System.out.print(num[copycounter] + ",");}
                    //If copycounter is equal to counter - 1, don't print a comma. Else, print a comma.
                    copycounter = copycounter + 1; }
                System.out.print("}");
                    System.out.println("");
                    System.out.println("");}
                //Prints out end '}' & prints spaces to keep console clean.
            else{System.out.println("Your list is currently empty.");
                    System.out.println("");}}
            //If the counter variable is 0, then the list is empty. Tells user if it is.

            if(input.charAt(0)=='F'||input.charAt(0)=='f') {
                System.out.println("");
                System.out.println("Thank you for using Austin Reichert's program. Have a good day.");
                System.exit(0);}
            }
            //Leaves program.
        }
    }
}