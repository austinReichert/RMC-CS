package Lab1;

//Austin Reichert
//September 11th, 2019
//Collaborators: Tanner Steorts

// *NOTE* This does not take strings or characters yet; once I learn how to check for that stuff I will put it in my codes.

import java.util.Scanner;
//Imports the Scanner tool

public class payroll {
    //java class

    public static void main(String[] args) {
        //this is where the code goes

        Scanner scan = new Scanner(System.in);
        //Recalls the scanner

        System.out.println("Enter how many years you have been working here and your total salary in only numbers.");
        //Asks the user to type in how long they have been working here and what their total salary is.

        double year = scan.nextDouble();
        double salary = scan.nextDouble();
        //Looks for information provided by user

        if (year < 0 && salary < 0) { System.out.println("The year and total salary you typed in is invalid!");   }
        //Tests if input by user (for year & salary) is invalid, if true, gives error message.

        else if (year < 0) { System.out.println("The year you typed in is invalid!");   }
        //Tests if input by user (for year) is invalid, if true, gives error message.

        else if (salary < 0) { System.out.println("The total salary you typed in is invalid!");   }
        //Tests if input by user (for salary) is invalid, if true, gives error message.

        else if (year >= 0 && year < 5) { System.out.println("Your salary is $" + salary);  }
        //Tests if user has 0-5 years in work, if true, only gives total salary.

        else if (year >= 5 && year < 10) { System.out.println("Your salary is $" + ((salary * .05) + salary));  }
        //Tests if user has 5-10 years in work, if true, gives total salary + 5%

        else if (year >= 10 && year < 20) { System.out.println("Your salary is $" + ((salary * .10) + salary)); }
        //Tests if user has 10-20 years in work, if true, gives total salary + 10%

        else if (year >= 20) { System.out.println("Your salary is $" + ((salary * .15) + salary));  }
        //Tests if user has 10-20 years in work, if true, gives total salary + 15%

    }}
