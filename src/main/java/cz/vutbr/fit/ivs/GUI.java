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


    /**
     * Entry point. Only initializes {@link GUI} class
     * @param args not used
     */
    public static void main(String [] args) {
        new GUI();
    }

    //Display Listener for parsing text from display
    ActionListener displayListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {

        }
    };

    /**
     * Constructor of GUI class.
     * Creates window and binds button listeners
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(647, 400);
        setContentPane(mainPanel);
        setVisible(true);

        display.addActionListener(displayListener);
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
        clearButton.addActionListener(getClearButtonListener());
        calcButton.addActionListener(getCalcButtonListener());
    }

    public ActionListener getButtonListener(String tag) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent){
                display.add(tag);
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
            }
        };
    }
}
