package com.codebind;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import cz.vutbr.fit.ivs.Calculator;
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
    public GUI()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 800);
        this.setContentPane(mainPanel);
        this.setVisible(true);

        display.addActionListener(displayListener);
        format = NumberFormat.getNumberInstance(display.getLocale());
    }

    //to clear text on display
    public void clear() {
        display.setText("");
    }

    //clearing screen and resetting memory and operation
    public void reset()
    {
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

    public void computeAllInDisplay()
    {
        String displayText = display.getText();
        String[] numbers;

        numbers = displayText.split("[*!+/-]");

        char operator = displayText.charAt(numbers[0].length());

        if(operator == '-' && numbers[0].length() == 0)
        {
            numbers[1] = "-" + numbers[1];
            operator = displayText.charAt(numbers[1].length());
            setOperation(operator);
            displayDouble(calculate(Double.parseDouble(numbers[1]), Double.parseDouble(numbers[2])));
        }
        else
        {
            setOperation(operator);
            displayDouble(calculate(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1])));
        }
    }

    public void setOperation(char operator)
    {
        switch (operator)
        {
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
            default://TODO exception
                reset();
        }
    }
}