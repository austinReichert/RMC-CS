package packagee;

public class WaitForNum1 implements State{

    private Calculator calculator;

    public WaitForNum1(Calculator calculator){
        this.calculator = calculator;
    }
    //constructor

    @Override
    public void buttonDigitorDot(String buttonLabel) {
        if(calculator.getNum1().contains(".")&&buttonLabel.equals(".")){
            System.out.println("Attempted to enter another decimal point.\n");
            //makes sure only one decimal place is entered.
        } else {
        calculator.setNum1(calculator.getNum1() + buttonLabel);
        //sets num1

        if(calculator.getNum1().equals(".")) {
            calculator.setNum1("0."); }
        //If '.' is entered first, automatically changes it to "0."
        }

        calculator.display(calculator.getNum1());
        System.out.println("The first number is: " + calculator.getNum1());
        //Adds numbers to a string and prints it to calculator.
    }

    @Override
    public void buttonOper(String buttonLabel) {

        if(!calculator.getNum1().equals("")){
            calculator.setOper(buttonLabel);
            calculator.setCurrentState(new WaitForNum2(calculator));
            System.out.println("The operation is: " + calculator.getOper());
            calculator.display(calculator.getNum1() + calculator.getOper());
            //If something is entered the operation is set, sets the new state, and displays to calculator gui.
        }
        else {
            System.out.println("No first number is set!");
            //Makes sure a num1 is set. Does not print anything to calculator.
        } }

    @Override
    public void buttonEquals(){
        System.out.println("Cannot equals a single number!");
        //do nothing.
    }
}
