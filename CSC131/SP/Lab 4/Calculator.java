package packagee;

//Note: There are a lot of system prints. This is to manage what the calculator is doing in the
//console. Consider this a log of its actions. :)

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//imports good stuff

public class Calculator{

    private String answer;
    private String num1 = "";
    private String num2 = "";
    private String oper = "";
    private State currentState;

    private JTextField txt = new JTextField("                                                      ");
    //created here to keep in scope

    //Getters and Setters
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getNum1() {
        return num1;
    }
    public void setNum1(String num1) {
        this.num1 = num1;
    }
    public String getNum2() {
        return num2;
    }
    public void setNum2(String num2) {
        this.num2 = num2;
    }
    public String getOper() {
        return oper;
    }
    public void setOper(String oper) {
        this.oper = oper;
    }
    public void setCurrentState(State newState) {
        this.currentState = newState;
    }
    public State getCurrentState() {
        return currentState;
    }
    //I never used this for some reason. oops.

    //Calculator Commands.
    public void display(String toDisplay){
        txt.setText(toDisplay);
    }
    //Changes the text displayed in the text box.
    public void performCalc(){
        double ans = 0;
        double numA = Double.parseDouble(num1);
        double numB = Double.parseDouble(num2);
        //Converts num1 and num2 from strings to ints

        if(getOper().equals("+")){
            ans = numA + numB;
        }
        else if(getOper().equals("-")){
            ans = numA - numB;
        }
        else if(getOper().equals("*")){
            ans = numA * numB;
        }
        else if(getOper().equals("/")){
            ans = numA / numB;
        }
        setAnswer(String.valueOf(ans));
        //Changes 'ans' from a int to a string and sets 'ans' as the answer.
    }
    //Performs the expression and sets the answer.

    //State Actions
    public void buttonDigitOrDot(String buttonLabel){
        currentState.buttonDigitorDot(buttonLabel);
    }

    public void buttonOper(String buttonLabel){
        currentState.buttonOper(buttonLabel);
    }

    public void buttonEquals(){
        currentState.buttonEquals();
    }
    //Delegated to the current state itself.

    //Gui
    public void CalculatorWindow(){
        setCurrentState(new WaitForNum1(this));
        JFrame frame = new JFrame();
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        //Sets the containers layout

        JPanel textFlowLayout = new JPanel(new FlowLayout());
        //Layout for textbox
        JPanel numberLayoutPanel = new JPanel(new GridLayout(4,3));
        //Layout for nums
        JPanel symbolLayoutPanel = new JPanel(new GridLayout(5,1));
        //Layout for symbols

        container.add(textFlowLayout, BorderLayout.NORTH);
        //adds to container (top side)
        container.add(numberLayoutPanel, BorderLayout.CENTER);
        //adds to container (middle)
        container.add(symbolLayoutPanel,BorderLayout.EAST);
        //adds to container (right side)

        textFlowLayout.add(txt);
        txt.setEnabled(false);
        //makes it so the textbox cannot be messed with. (text box created above)

        //Button Creation
        //Lines  create a button, add to appropriate panel, and add the appropriate action listener.
        JButton one = new JButton("1");
        numberLayoutPanel.add(one);
        one.addActionListener(new NumberActionListener());

        JButton two = new JButton("2");
        numberLayoutPanel.add(two);
        two.addActionListener(new NumberActionListener());

        JButton three = new JButton("3");
        numberLayoutPanel.add(three);
        three.addActionListener(new NumberActionListener());

        JButton four = new JButton("4");
        numberLayoutPanel.add(four);
        four.addActionListener(new NumberActionListener());

        JButton five = new JButton("5");
        numberLayoutPanel.add(five);
        five.addActionListener(new NumberActionListener());

        JButton six = new JButton("6");
        numberLayoutPanel.add(six);
        six.addActionListener(new NumberActionListener());

        JButton seven = new JButton("7");
        numberLayoutPanel.add(seven);
        seven.addActionListener(new NumberActionListener());

        JButton eight = new JButton("8");
        numberLayoutPanel.add(eight);
        eight.addActionListener(new NumberActionListener());

        JButton nine = new JButton("9");
        numberLayoutPanel.add(nine);
        nine.addActionListener(new NumberActionListener());

        JButton dot = new JButton(".");
        numberLayoutPanel.add(dot);
        dot.addActionListener(new NumberActionListener());

        JButton zero = new JButton("0");
        numberLayoutPanel.add(zero);
        zero.addActionListener(new NumberActionListener());

        JButton quit = new JButton("QUIT");
        numberLayoutPanel.add(quit);
        quit.addActionListener(new QuitActionListener());
        //Is on numberpanel because there was room left.

        JButton plus = new JButton("+");
        symbolLayoutPanel.add(plus);
        plus.addActionListener(new OperActionListener());

        JButton minus = new JButton("-");
        symbolLayoutPanel.add(minus);
        minus.addActionListener(new OperActionListener());

        JButton divide = new JButton("/");
        symbolLayoutPanel.add(divide);
        divide.addActionListener(new OperActionListener());

        JButton times = new JButton("*");
        symbolLayoutPanel.add(times);
        times.addActionListener(new OperActionListener());

        JButton equals = new JButton("=");
        symbolLayoutPanel.add(equals);
        equals.addActionListener(new EqualsActionListener());

        frame.setResizable(false);
        //Makes it so nobody can resize the window.
        frame.pack();
        frame.setVisible(true);
    }
    //Creates the calculator window and fills it.

    //Action Listeners
    public class EqualsActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonEquals();
        }
    }

    public class OperActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonOper(((JButton)e.getSource()).getText());
        }
    }

    public class NumberActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buttonDigitOrDot(((JButton)e.getSource()).getText());
            //Grabs the buttons label
        }
    }
    //Delegates to state actions above. Oper and number pass on the buttonLabel.

    public class QuitActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            txt.setText("EXITING CALCULATOR");
            System.out.println("\nEnding calculator program.");
            System.exit(-2);
            //Prints to calculator, prints to console, ends program.
        } }
    //Does not need specific state action as this action only relies on the button.
}
