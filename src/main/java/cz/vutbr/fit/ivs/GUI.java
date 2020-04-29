package cz.vutbr.fit.ivs;

import javax.swing.*;
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
        button9.addActionListener(getButtonListener("9"));
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
        buttonHelp.addActionListener(getHelpButtonListener());
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
