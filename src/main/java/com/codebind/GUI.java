package com.codebind;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import cz.vutbr.fit.ivs.Operations;
import cz.vutbr.fit.ivs.MathLib;

public class GUI extends JFrame
{
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
    ActionListener displayListener = new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            displayResult();
        }
    };

    //Constructor
    public GUI()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200,800);
        this.setContentPane(mainPanel);
        this.setVisible(true);

        display.addActionListener(displayListener);
        format = NumberFormat.getNumberInstance(display.getLocale());
    }

    //converting text from display to number
    public double getValue()
    {
        final String text = display.getText();
        if (text == null || text.length() == 0)
        {
            return 0;
        }

        //trying to parse text as double
        //calling exception when there is not a number
        try
        {
            return format.parse(text).doubleValue();
        }
        catch (ParseException e)
        {
            return 0;
        }
    }

    //to clear text on display
    public void clear()
    {
        display.setText("");
    }

    //clearing screen and resetting memory and operation
    public void reset()
    {
        clear();
        memory = 0;
        operation = Operations.NONE;
    }

    //Save the value from the display to the memory and clear the scree(why?)
    public void saveAndClear()
    {
        memory = getValue();
        clear();
    }

    //The calculated value is stored inside memory
    public void calculateToMemoryAndClear()
    {
        memory = calculate();
        clear();
    }

    //formatting the double value to string and setting it to display
    public void displayDouble(double d)
    {
        display.setText(format.format(d));
    }

    //Just displays the result :)
    public void displayResult()
    {
        displayDouble(calculate());
    }

    //Calls the calculate method from MathLib
    public double calculate()
    {
        return MathLib.calculate(memory, getValue(), operation);
    }


}
