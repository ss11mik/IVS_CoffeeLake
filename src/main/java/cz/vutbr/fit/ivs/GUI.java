package cz.vutbr.fit.ivs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The purpose of this class is to communicate with GUI and pass actions to {@link cz.vutbr.fit.ivs.Calculator}
 * It also contains the main() method
 *
 * @author Marek Lohn
 */
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
    private Calculator display;
    private JButton clearButton;
    private JButton calcButton;
    private JTextField memoryView;
    private JButton buttonPow;
    private JButton buttonSqrt;
    private JButton buttonFact;
    private JButton buttonMod;
    private JButton buttonDiv;
    private JButton buttonMul;
    private JButton buttonSub;
    private JButton buttonAdd;
    private JButton resetButton;
    private JButton buttonHelp;

    private void init(){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.white);
        mainPanel.setForeground(Color.black);
        mainPanel.setSize(647, 400);
        mainPanel.setLayout(new GridLayout(6,1));

        memoryView = new JTextField();
        display = new Calculator();
        buttonHelp = getButtonUI("Help");
        calcButton = getButtonUI("Calculate");
        clearButton = getButtonUI("Clear");
        resetButton = getButtonUI("Reset");
        button0 = getButtonUI("0");
        button1 = getButtonUI("1");
        button2 = getButtonUI("2");
        button3 = getButtonUI("3");
        button4 = getButtonUI("4");
        button5 = getButtonUI("5");
        button6 = getButtonUI("6");
        button7 = getButtonUI("7");
        button8 = getButtonUI("8");
        button9 = getButtonUI("9");
        buttonDiv = getButtonUI("/");
        buttonMul = getButtonUI("x");
        buttonSqrt = getButtonUI("sqrt( )");
        buttonPow = getButtonUI("pow( )");
        buttonFact = getButtonUI("!");
        buttonMod = getButtonUI("%");
        buttonSub = getButtonUI("-");
        buttonParentheses = getButtonUI(".");
        buttonAdd = getButtonUI("+");

        GridLayout row1 = new GridLayout(1,7);
        mainPanel.add(memoryView);
        mainPanel.add(buttonHelp);

        mainPanel.add(display);
        mainPanel.add(calcButton);

        mainPanel.add(clearButton);
        mainPanel.add(resetButton);
        mainPanel.add(button7);
        mainPanel.add(button8);
        mainPanel.add(button9);
        mainPanel.add(buttonDiv);

        mainPanel.add(buttonSqrt);
        mainPanel.add(buttonPow);
        mainPanel.add(button4);
        mainPanel.add(button5);
        mainPanel.add(button6);
        mainPanel.add(buttonMul);

        mainPanel.add(buttonFact);
        mainPanel.add(buttonMod);
        mainPanel.add(button1);
        mainPanel.add(button2);
        mainPanel.add(button3);
        mainPanel.add(buttonSub);

        mainPanel.add(button0);
        mainPanel.add(buttonParentheses);
        mainPanel.add(buttonAdd);
    }

    private JButton getButtonUI(String tag){
        JButton button = new JButton();
        button.setText(tag);

        return button;
    }

    /**
     * Entry point. Only initializes {@link GUI} class
     * @param args not used
     */
    public static void main(String [] args) {
        new GUI();
    }

    /**
     * Constructor of GUI class.
     * Creates window and binds button listeners
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(647, 400);
        init();
        setContentPane(mainPanel);
        setVisible(true);

        button0.addActionListener(getButtonListener("0"));
        button1.addActionListener(getButtonListener("1"));
        button2.addActionListener(getButtonListener("2"));
        button3.addActionListener(getButtonListener("3"));
        button4.addActionListener(getButtonListener("4"));
        button5.addActionListener(getButtonListener("5"));
        button6.addActionListener(getButtonListener("6"));
        button7.addActionListener(getButtonListener("7"));
        button8.addActionListener(getButtonListener("8"));
        button9.addActionListener(getButtonListener("9"));/*
        buttonParentheses.addActionListener(getButtonListener("."));
        buttonFact.addActionListener(getOperationListener("!"));
        buttonAdd.addActionListener(getOperationListener("+"));
        buttonSub.addActionListener(getOperationListener("-"));
        buttonMul.addActionListener(getOperationListener("*"));
        buttonDiv.addActionListener(getOperationListener("/"));
        buttonMod.addActionListener(getOperationListener("%"));
        buttonPow.addActionListener(getOperationListener("^"));
        buttonSqrt.addActionListener(getOperationListener("#"));
        clearButton.addActionListener(getClearButtonListener());
        calcButton.addActionListener(getCalcButtonListener());
        resetButton.addActionListener(getResetButtonListener());
        buttonHelp.addActionListener(getHelpButtonListener());*/
    }

    public ActionListener getButtonListener(String tag) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.add(tag);
            }
        };
    }

    public ActionListener getOperationListener(String tag) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.add(tag);
                memoryView.setText(display.memoryView() + tag);
            }
        };
    }

    public ActionListener getClearButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.clear();
            }
        };
    }

    public ActionListener getCalcButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.calculateAndSetText();
                display.resetMemory();
            }
        };
    }

    public ActionListener getResetButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.reset();
            }
        };
    }

    public ActionListener getHelpButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                JOptionPane.showMessageDialog(mainPanel, "To work with this calculator you can either use buttons\n or write inside the text field using coresponding keybinds.\n\nKeyBind: \n\t0-9 to instert numbers \n\t. to insert floating point \n\tEnter to calculate \n\t+-*/ for some basic operations \n\t^ power \n\t# square root \n\t% modulus");
            }
        };
    }
}
