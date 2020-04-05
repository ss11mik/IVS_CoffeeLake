package gui.myGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import cz.vutbr.fit.ivs.Operations;
import cz.vutbr.fit.ivs.MathLib;

public class GUI extends JFrame {
    private JPanel mainPanel;
    private JButton button3;
    private JButton button2;
    private JButton button1;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button0;
    private JButton buttonParentheses;
    private JFormattedTextField display;

    private final NumberFormat format;
    private int operation = Operations.NONE;
    private double memory;

    //Display Listener for parsing text from display
    ActionListener displayListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            computeAllInDisplay();
        }
    };

    //Constructor
    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setContentPane(mainPanel);
        this.setVisible(true);

        display.addActionListener(displayListener);
        format = NumberFormat.getNumberInstance(display.getLocale());
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "0");
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "1");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "2");
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "3");
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "4");
            }
        });
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "5");
            }
        });
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "6");
            }
        });
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "7");
            }
        });
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "8");
            }
        });
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + "9");
            }
        });
        buttonParentheses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(display.getText() + ".");
            }
        });
    }

    //to clear text on display
    public void clear() {
        display.setText("");
    }

    //clearing screen and resetting memory and operation
    public void reset() {
        clear();
        memory = 0;
        operation = Operations.NONE;
    }

    //formatting the double value to string and setting it to display
    public void displayDouble(double d) {
        display.setText(format.format(d));
    }

    //Calls the calculate method from MathLib
    public double calculate(double num1, double num2) {
        return MathLib.calculate(num1, num2, operation);
    }

    public void computeAllInDisplay() {
        String displayText = display.getText();
        String[] numbers;

        try {
            numbers = displayText.split("[*!+/-]");
            char operator = displayText.charAt(numbers[0].length());

            if (operator == '-' && numbers[0].length() == 0) {
                numbers[1] = "-" + numbers[1];
                operator = displayText.charAt(numbers[1].length());
                setOperation(operator);
                displayDouble(calculate(Double.parseDouble(numbers[1]), Double.parseDouble(numbers[2])));
            } else if (numbers[0].length() == 0) {
                display.setText(numbers[1]);
            } else if(operator == '!') {
                setOperation(operator);
                displayDouble(calculate(0, Double.parseDouble(numbers[0])));
            } else {
                setOperation(operator);
                displayDouble(calculate(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])));
            }
        }
        catch(StringIndexOutOfBoundsException e) {
            return;
        }
        catch (NumberFormatException e){
            display.setText("You should not use these as numbers");
            return;
        }
    }

    public void setOperation(char operator) {
        switch (operator) {
            case '+':
                operation = Operations.ADD;
                break;
            case '-':
                //TODO when user wants to switch sign? special button
                operation = Operations.SUB;
                break;
            case '*':
                operation = Operations.MUL;
                break;
            case '/':
                operation = Operations.DIV;
                break;
            case '!':
                operation = Operations.FACT;
                break;
            default:
                reset();
        }
    }
}
