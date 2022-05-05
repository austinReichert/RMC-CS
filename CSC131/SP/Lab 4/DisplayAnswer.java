package packagee;

public class DisplayAnswer implements State {

    private Calculator calculator;

    public DisplayAnswer(Calculator calculator){
        this.calculator = calculator;
    }
    //constructor

    @Override
    public void buttonDigitorDot(String buttonLabel) {
        calculator.setNum1(buttonLabel);
        if(calculator.getNum1().equals(".")){
            calculator.setNum1("0.");
        }
        //makes sure to change '.' to "0."

        calculator.setNum2("");
        calculator.setAnswer("");
        calculator.display(calculator.getNum1());
        calculator.setCurrentState(new WaitForNum1(calculator));
        System.out.println("Calculator was reset.\n \nThe first number is: " + calculator.getNum1());
        //Resets everything but num1.
    }

    @Override
    public void buttonOper(String buttonLabel) {
        calculator.setOper(buttonLabel);
        calculator.setNum2("");
        System.out.println("The operation was changed to: " + buttonLabel);
        System.out.println("The second number has been reset.");
        calculator.display(calculator.getNum1() + calculator.getOper());
        calculator.setCurrentState(new WaitForNum2(calculator));
        //Erases num2, sets oper as new oper, returns to previous state.
    }

    @Override
    public void buttonEquals() {
        System.out.println("The answer is: "+ calculator.getAnswer());
        calculator.display(calculator.getAnswer());
        //prints answer. does not change state.
    }
}
