package Lab6;

//Austin Reichert
//October 31, 2019
//Collaborators: No-one.

import java.util.InputMismatchException; //Imports try-catch stuff
import java.util.Scanner; //Imports the scanner tool

public class BinaryDecimalHexadecimal {
    //java class
    public static void main(String[] args) {
        //code goes here

        String bhd = ""; //Dictates what functions are ran (menu)
        String binary = ""; //Variable for binary numbers (inputted ones)
        String hexadecimal = ""; //Variable for hexadecimals (inputted ones)
        int i = 0; //Counter variable
        int katch = 0; //Catch variable
        int decimal = 0; //Variable for decimal numbers

        Scanner scan = new Scanner(System.in); //Recalls scanner

        while(bhd.equals("")){
            System.out.println("Enter decimal, hexadecimal or binary.");
            bhd = scan.nextLine();
            if(bhd.equals("decimal") || bhd.equals("Decimal") || bhd.equals("Hexadecimal") || bhd.equals("hexadecimal") || bhd.equals("binary") || bhd.equals("Binary")) {
                System.out.print(""); }
            //Checks if user input is any of the three listed.
            else{
                bhd = "";
                System.out.println("");
                System.out.println("Invalid Input! Try again!");}}
        // If the users input is not any of the three listed, asks the user to try again and resets their previous input. (else statement)

        if(bhd.equals("decimal") || bhd.equals("Decimal")){
            while(decimal == 0){
            System.out.println("Enter your decimal number");
            try{ decimal = scan.nextInt(); }
            catch(InputMismatchException fd){
                System.out.println("Invalid input! Retry using a number!");
                System.out.println("");
                decimal = 0;
                scan.nextLine();}}
            //Makes sure user enters a number for the decimals and not a string/long/etc.
            System.out.println("");
            System.out.println("Hexadecimal: " + DecimalToHexadecimal(decimal));
            System.out.println("Binary: " + DecimalToBinary(decimal)); }
        //Prints results of Decimal to Binary and Decimal to Hexadecimal.

        if(bhd.equals("Hexadecimal") || bhd.equals("hexadecimal")){
            while(hexadecimal.equals("")){
                System.out.println("Enter your hexadecimal.");
                hexadecimal = scan.nextLine();
                i = 0;
                katch = 0;
                //Resets variables
                while(i < hexadecimal.length()) {
                if(hexadecimal.charAt(i) == 'A' || hexadecimal.charAt(i) == 'a' || hexadecimal.charAt(i) == 'B' || hexadecimal.charAt(i) == 'b'|| hexadecimal.charAt(i) == 'C' || hexadecimal.charAt(i) == 'c' || hexadecimal.charAt(i) == 'D' || hexadecimal.charAt(i) == 'd' || hexadecimal.charAt(i) == 'E' || hexadecimal.charAt(i) == 'e' || hexadecimal.charAt(i) == 'F' || hexadecimal.charAt(i) == 'f' || hexadecimal.charAt(i) == '0' || hexadecimal.charAt(i) == '1' || hexadecimal.charAt(i) == '2' || hexadecimal.charAt(i) == '3' || hexadecimal.charAt(i) == '4' || hexadecimal.charAt(i) == '5' || hexadecimal.charAt(i) == '6' || hexadecimal.charAt(i) == '7' || hexadecimal.charAt(i) == '8' || hexadecimal.charAt(i) == '9'){
                    System.out.print(""); }
                else { katch++; }
                i++;}
                //Asks user for input of a hexadecimal. Tested below if true with 'katch'

                if(katch > 0){
                    System.out.println("Your input is invalid! Retry with a hexadecimal!");
                    hexadecimal = ""; }}
            //Uses 'katch' to make sure nothing but what is wanted goes into my numbers
            System.out.println("Binary: " + HexadecimalToBinary(hexadecimal));
            System.out.println("Decimal: " + HexadecimalToDecimal(hexadecimal)); }
        //Prints results

        if(bhd.equals("binary") || bhd.equals("Binary")){
            while(binary.equals("")){
                System.out.println("Enter your binary number");
                binary = scan.nextLine();
                //Binary is used as a string, so no try-catch.
                i = 0;
                katch = 0;

                while(i < binary.length()){
                    if(binary.charAt(i) == '1' || binary.charAt(i) == '0'){
                        System.out.print("");}
                    else{katch++;}
                    i++;}
                //Tests if the binary is purely 1s and 0s, if not, asks the user to try again.
                //Uses 'katch' to stop the programming from progressing if anywhere in the input is not 1 or 0.
                if(katch > 0){ System.out.println("Your input is invalid! Retry with a binary number!");
                    binary = "";}}
            System.out.println("Decimal: ");
            System.out.println("Hexadecimal: "); }}
            //Neither of these work because I want to go to bed [[Austin at 1:30 AM, 10/31/19]]

    public static String FlipString(String str){
        String newString = "";
        int counter = str.length();
        while(counter > 0){
            newString = newString + str.charAt(counter - 1);
            counter--; }
        //Creates a new string and copies the older one but backwards. (Ex: Old "O3Lr#" *flipped* New "#rL3O")
        return newString; }

    public static String DecimalToHexadecimal(int decimal){
        String hexadecimal = "";
        int remainder = 0;
        int IsNegative = 0;

        if(decimal < 0){
        decimal = decimal * -1;
        IsNegative++; }
        //Checks if the number is negative. If so, stores the negative and makes the decimal positive.

        while(decimal > 0){
            remainder = decimal%16;
            decimal = decimal/16;
            //Finds remainder and makes decimal smaller

            if(remainder < 10){ hexadecimal = hexadecimal + remainder; }
            else if(remainder == 10){ hexadecimal = hexadecimal + "A";}
            else if(remainder == 11){ hexadecimal = hexadecimal + "B";}
            else if(remainder == 12){ hexadecimal = hexadecimal + "C";}
            else if(remainder == 13){ hexadecimal = hexadecimal + "D";}
            else if(remainder == 14){ hexadecimal = hexadecimal + "E";}
            else if(remainder == 15){ hexadecimal = hexadecimal + "F";}}
        //If the remainder is something, adds that. (Remainder is 11, adds "B")

        if(IsNegative == 1){
            hexadecimal = hexadecimal + "-"; }
        //Adds '-'
        hexadecimal = FlipString(hexadecimal); //Flips the string
        return hexadecimal; }

        public static double HexadecimalToDecimal(String hexadecimal){
        double decimal = 0; //Is what this function is intended to find.
        int number = 0; //Used in formula at bottom of function.
        int counter = hexadecimal.length() - 1; //Goes down from hexadecimal.length - 1
        int numcounter = 0; //Counts up from 0

        while(counter > -1){
            number = 0;
            if(hexadecimal.charAt(counter) == '0'){ number = 0;}
            else if(hexadecimal.charAt(counter) == '1'){ number = 1; }
            else if(hexadecimal.charAt(counter) == '2'){ number = 2; }
            else if(hexadecimal.charAt(counter) == '3'){ number = 3; }
            else if(hexadecimal.charAt(counter) == '4'){ number = 4; }
            else if(hexadecimal.charAt(counter) == '5'){ number = 5; }
            else if(hexadecimal.charAt(counter) == '6'){ number = 6; }
            else if(hexadecimal.charAt(counter) == '7'){ number = 7; }
            else if(hexadecimal.charAt(counter) == '8'){ number = 8; }
            else if(hexadecimal.charAt(counter) == '9'){ number = 9; }
            else if(hexadecimal.charAt(counter) == 'A' || hexadecimal.charAt(counter) == 'a'){ number = 10; }
            else if(hexadecimal.charAt(counter) == 'B' || hexadecimal.charAt(counter) == 'b'){ number = 11; }
            else if(hexadecimal.charAt(counter) == 'C' || hexadecimal.charAt(counter) == 'c'){ number = 12; }
            else if(hexadecimal.charAt(counter) == 'D' || hexadecimal.charAt(counter) == 'd'){ number = 13; }
            else if(hexadecimal.charAt(counter) == 'E' || hexadecimal.charAt(counter) == 'e'){ number = 14; }
            else if(hexadecimal.charAt(counter) == 'F' || hexadecimal.charAt(counter) == 'f'){ number = 15; }
            //Sets number to a number depending on the character at 'counter'

            decimal = decimal + (number * (Math.pow(16, numcounter)));
            //The decimal is equal to number (1-15 depending on character) multiplied by 16 powered to the ? power (? is dictated by numcounter)
            //decimal = (# * (16^?))
            counter--;
            numcounter++; }
        return decimal; }

        public static String DecimalToBinary(int decimal){
        String binary = "";
        String hexadecimal = "";
        hexadecimal = DecimalToHexadecimal(decimal);
        binary = HexadecimalToBinary(hexadecimal);
        return binary;}
        //Converts the decimal to a hexadecimal, and the hexadecimal to binary.

        public static String HexadecimalToBinary(String hexadecimal) {
        String binary = ""; //General output of function
        String newbinary = ""; //Copies the binary string but inverted.
        int counter = 0; //Counter
        int flip = 0; //Used to keep track of if the numbers need to be flipped or not.

        if(hexadecimal.charAt(0) != '-'){
            //If the hexadecimal is not negative it does this.
            binary = binary + "0";
            //The '0' shows the binary is POSITIVE.
            while(counter < hexadecimal.length()){
                if(hexadecimal.charAt(counter) == '0'){binary = binary + "0000"; }
                else if(hexadecimal.charAt(counter) == '1'){binary = binary + "0001";}
                else if(hexadecimal.charAt(counter) == '2'){binary = binary + "0010";}
                else if(hexadecimal.charAt(counter) == '3'){binary = binary + "0011";}
                else if(hexadecimal.charAt(counter) == '4'){binary = binary + "0100";}
                else if(hexadecimal.charAt(counter) == '5'){binary = binary + "0101";}
                else if(hexadecimal.charAt(counter) == '6'){binary = binary + "0110";}
                else if(hexadecimal.charAt(counter) == '7'){binary = binary + "0111";}
                else if(hexadecimal.charAt(counter) == '8'){binary = binary + "1000";}
                else if(hexadecimal.charAt(counter) == '9'){binary = binary + "1001";}
                else if(hexadecimal.charAt(counter) == 'A' || hexadecimal.charAt(counter) == 'a'){binary = binary + "1010";}
                else if(hexadecimal.charAt(counter) == 'B' || hexadecimal.charAt(counter) == 'b'){binary = binary + "1011";}
                else if(hexadecimal.charAt(counter) == 'C' || hexadecimal.charAt(counter) == 'c'){binary = binary + "1100";}
                else if(hexadecimal.charAt(counter) == 'D' || hexadecimal.charAt(counter) == 'd'){binary = binary + "1101";}
                else if(hexadecimal.charAt(counter) == 'E' || hexadecimal.charAt(counter) == 'e'){binary = binary + "1110";}
                else if(hexadecimal.charAt(counter) == 'F' || hexadecimal.charAt(counter) == 'f'){binary = binary + "1111";}
                //Prints the corresponding code depending on the hexadecimal symbol (like F is 1111 (15) in binary)
                //I was unsure of what numbers to make small or to make big, so ALL are big (besides 0,1,2,3).
                counter++; }}
        else{ //This is the same code, but does the make-shift 2s compliment instead.
            binary = binary + "0";
            //The '0' shows the binary is POSITIVE.
            while(counter < hexadecimal.length()){
                if(hexadecimal.charAt(counter) == '0'){binary = binary + "0000"; }
                else if(hexadecimal.charAt(counter) == '1'){binary = binary + "0001";}
                else if(hexadecimal.charAt(counter) == '2'){binary = binary + "0010";}
                else if(hexadecimal.charAt(counter) == '3'){binary = binary + "0011";}
                else if(hexadecimal.charAt(counter) == '4'){binary = binary + "0100";}
                else if(hexadecimal.charAt(counter) == '5'){binary = binary + "0101";}
                else if(hexadecimal.charAt(counter) == '6'){binary = binary + "0110";}
                else if(hexadecimal.charAt(counter) == '7'){binary = binary + "0111";}
                else if(hexadecimal.charAt(counter) == '8'){binary = binary + "1000";}
                else if(hexadecimal.charAt(counter) == '9'){binary = binary + "1001";}
                else if(hexadecimal.charAt(counter) == 'A' || hexadecimal.charAt(counter) == 'a'){binary = binary + "1010";}
                else if(hexadecimal.charAt(counter) == 'B' || hexadecimal.charAt(counter) == 'b'){binary = binary + "1011";}
                else if(hexadecimal.charAt(counter) == 'C' || hexadecimal.charAt(counter) == 'c'){binary = binary + "1100";}
                else if(hexadecimal.charAt(counter) == 'D' || hexadecimal.charAt(counter) == 'd'){binary = binary + "1101";}
                else if(hexadecimal.charAt(counter) == 'E' || hexadecimal.charAt(counter) == 'e'){binary = binary + "1110";}
                else if(hexadecimal.charAt(counter) == 'F' || hexadecimal.charAt(counter) == 'f'){binary = binary + "1111";}
                //Prints the corresponding code depending on the hexadecimal symbol (like F is 1111 (15) in binary)
                //I was unsure of what numbers to make small or to make big, so ALL are big (besides 0,1,2,3).
                counter++; }
            counter = binary.length() - 1;
            //This is where it begins... all I did was flip stuff...
            while(counter > -1) {

                //The loop below looks for the first one (starting at the ones place).
                //If it finds one it inverts everything beyond that point.
                //(Flip dictates when numbers start to get inverted)
                if(flip != 1){
                    if(binary.charAt(counter) == '1'){
                        flip++;
                    newbinary = newbinary + "1";}
                    //Starts the flipping process if one is found, and saves the last one.
                    if(binary.charAt(counter) == '0'){
                        newbinary = newbinary + "0"; }}
                else{
                    if(binary.charAt(counter) == '1'){
                        newbinary = newbinary + "0"; }
                    if(binary.charAt(counter) == '0'){
                        newbinary = newbinary + "1"; }}
                //If 1 exists, its changed to 0. If 0 exists, it is changed to 1.
                // [EXAMPLE 01001 (9) --> 10111 (-9)] [EXAMPLE 001011101 (93) --> 110100011 (-93)]
                counter--; }
            counter = newbinary.length();
            binary = "";
            //Clears and resets variables for while loop below.
            while(counter > 0){
                binary = binary + newbinary.charAt(counter-1);
                counter--; }} //Another 'FlipString' function but for this specific situation.
        return binary; }
}