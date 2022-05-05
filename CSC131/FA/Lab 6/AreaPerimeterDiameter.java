package Lab6;

//Austin Reichert
//October 31, 2019
//Collaborators: Caiden Peterson (tester)

import java.util.InputMismatchException; //Imports the try-catch stuff
import java.util.Scanner; //Imports the Scanner

public class AreaPerimeterDiameter { //java class
    public static void main(String[] args) { //code goes here

        String apd = ""; //Dictates what functions are ran
        double number = 0; //Number inputted into functions
        Scanner scan = new Scanner(System.in); //Recalls scanner

            apd = "";
            number = 0;
            //Reset variables

            while(apd.equals("")){
            System.out.println("Enter area, circumference or diameter.");
            apd = scan.nextLine();
            if(apd.equals("area") || apd.equals("Area") || apd.equals("circumference") || apd.equals("Circumference") || apd.equals("diameter") || apd.equals("Diameter")){
                System.out.print(""); }
            else{ apd = "";
                System.out.println("Invalid Input! Try again!");}}
            //This block dictates what functions are ran.
            //If/else statement above checks whether the users input actually exists. If not, asks the user for a valid input.

                while(number == 0){
            System.out.println("Type in a number.");
            try{ number = scan.nextDouble(); }
            catch(InputMismatchException pf){
                scan.nextLine();
                System.out.println("Retry! That is not a valid number!");
                number = 0;}
                    //Checks if the users input is a number, if not, does not continue until users input is a valid input.

            if(number < 0){ System.out.println("Your number cannot be negative!");
                number = 0; }}
            //Checks if users input is a negative, if so, does not continue until user inputs a positive number.

            System.out.println("");

                if (apd.equals("area") || apd.equals("Area")) {
                    System.out.println("Diameter: " + AreaToDiameter(number));
                    System.out.println("Circumference: " + AreaToCircumference(number)); }
                //Prints the diameter and circumference using the users inputted number (area)
                else if (apd.equals("circumference") || apd.equals("Circumference")) {
                    System.out.println("Area: " + CircumferenceToArea(number));
                    System.out.println("Diameter: " + CircumferenceToDiameter(number));}
                //Prints the area and diameter using the users inputted number (circumference)
                else if (apd.equals("diameter") || apd.equals("Diameter")) {
                    System.out.println("Area: " + DiameterToArea(number));
                    System.out.println("Circumference: " + DiameterToCircumference(number));
                //Prints the area and circumference using the users inputted number (diameter)
                }}

    public static double AreaToDiameter(double area){
        double diameter = 0;
        diameter = 2*(Math.sqrt(area/Math.PI));
        //Diameter = 2√(A/π)
        return diameter; }
        //Math for converting area to diameter.

        public static double AreaToCircumference(double area) {
        double circumference = 0;
        circumference = Math.sqrt(4*Math.PI*area);
        //Circumference	= √(4πA)
            return circumference; }
            //Math for converting area to circumference.

    public static double DiameterToCircumference(double diameter) {
        double circumference = 0;
        circumference = Math.PI*diameter;
        //Circumference	= πD
        return circumference; }
        //Math for converting diameter to circumference.

    public static double DiameterToArea(double diameter) {
        double Area = 0;
        double radius = diameter/2;
        Area = Math.PI*(radius*radius);
        //Circumference	= πD
        return Area; }
        //Math for converting diameter to area.

        public static double CircumferenceToDiameter(double circumference){
        double diameter = 0;
        diameter = (circumference/Math.PI);
        //diameter = C/π
            return diameter; }
            //Math for converting circumference to diameter.

    public static double CircumferenceToArea(double circumference){
        double area = 0;
        area = ((circumference*circumference)/(4*Math.PI));
        //area = c^2/4π
        return area; }
        //Math for converting circumference to area.
}
