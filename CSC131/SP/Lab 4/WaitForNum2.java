package packagee;

public class WaitForNum2 implements State{

    private Calculator calculator;

    public WaitForNum2(Calculator calculator){
        this.calculator = calculator;
    }
    //constructor

    @Override
    public void buttonDigitorDot(String buttonLabel) {
        if(calculator.getNum2().contains(".")&&buttonLabel.equals(".")){
            System.out.println("Attempted to enter another decimal point.\n");
        } else {
        calculator.setNum2(calculator.getNum2() + buttonLabel);
        //sets num2

        if(calculator.getNum2().equals(".")){
            calculator.setNum2("0."); }
            //If '.' is entered first, automatically changes it to "0."
        }

        System.out.println("The second number is: " + calculator.getNum2());
        calculator.display(calculator.getNum1() + calculator.getOper() + calculator.getNum2());
        //Sets number, updates console, prints current operation.
    }

    @Override
    public void buttonOper(String buttonLabel) {
        calculator.setOper(buttonLabel);
        System.out.println("The operation was changed to: " + buttonLabel);
        calculator.display(calculator.getNum1() + calculator.getOper());
        calculator.setNum2("");
        //Prints both num1 and the oper. resets num2.
    }

    @Override
    public void buttonEquals() {
        if(!calculator.getNum2().equals("")){
            calculator.performCalc();
            calculator.display(calculator.getAnswer());
            System.out.println("Equation completed: " + calculator.getNum1() + " " + calculator.getOper() + " " + calculator.getNum2() + " = " + calculator.getAnswer());
            calculator.setCurrentState(new DisplayAnswer(calculator));
            //Performs the calculations, changes state and prints the answer.
        }
        else {
            System.out.println("No second number is set!");
            //Do nothing. Makes sure user enters a number for num2.
        }
    }
}
