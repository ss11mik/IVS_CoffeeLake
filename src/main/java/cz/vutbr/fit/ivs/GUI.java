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
    private JButton buttonRandI;
    private JButton buttonRandF;

    /**
     * Initializes all UI components
     */
    private void init(){
        mainPanel = new JPanel();
        mainPanel.setBackground(Color.darkGray);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));

        memoryView = new JTextField();
        memoryView.setEditable(false);
        memoryView.setBackground(Color.black);
        memoryView.setForeground(Color.white);
        memoryView.setHorizontalAlignment(SwingConstants.RIGHT);
        display = new Calculator();
        display.setBackground(Color.black);
        display.setForeground(Color.white);

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
        buttonRandI = getButtonUI("randI( )");
        buttonRandF = getButtonUI("randF( )");

        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEADING,5,0));
        JPanel viewFields = new JPanel(new GridLayout(2,1,0,5));
        JPanel buttonFields = new JPanel(new GridLayout(2,1,0,5));

        row1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        row1.setBackground(Color.darkGray);

        viewFields.setPreferredSize(new Dimension(500,80));
        viewFields.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        viewFields.setBackground(Color.darkGray);

        buttonFields.setPreferredSize(new Dimension(100,80));
        buttonFields.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        buttonFields.setBackground(Color.darkGray);

        viewFields.add(memoryView);
        buttonFields.add(buttonHelp);
        viewFields.add(display);
        buttonFields.add(calcButton);
        row1.add(viewFields);
        row1.add(buttonFields);
        mainPanel.add(row1);

        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEADING,5,0));

        row2.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        row2.setBackground(Color.darkGray);

        JPanel col1 = getPanel();
        JPanel col2 = getPanel();
        JPanel col3 = getPanel();
        JPanel col4 = getPanel();
        JPanel col5 = getPanel();
        JPanel col6 = getPanel();
        JPanel col7 = getPanel();
        col1.setPreferredSize(new Dimension(85,260));
        col2.setPreferredSize(new Dimension(85,260));
        col3.setPreferredSize(new Dimension(140,260));
        col4.setPreferredSize(new Dimension(70,260));
        col5.setPreferredSize(new Dimension(70,260));
        col6.setPreferredSize(new Dimension(70,260));
        col7.setPreferredSize(new Dimension(70,260));

        col1.add(clearButton);
        col2.add(resetButton);
        col4.add(button7);
        col5.add(button8);
        col6.add(button9);
        col7.add(buttonDiv);

        col1.add(buttonSqrt);
        col2.add(buttonPow);
        col4.add(button4);
        col5.add(button5);
        col6.add(button6);
        col7.add(buttonMul);

        col1.add(buttonFact);
        col2.add(buttonMod);
        col4.add(button1);
        col5.add(button2);
        col6.add(button3);
        col7.add(buttonSub);

        col1.add(buttonRandF);
        col2.add(buttonRandI);
        col5.add(button0);
        col6.add(buttonParentheses);
        col7.add(buttonAdd);

        row2.add(col1);
        row2.add(col2);
        row2.add(col3);
        row2.add(col4);
        row2.add(col5);
        row2.add(col6);
        row2.add(col7);
        mainPanel.add(row2);
    }

    /**
     * @param tag Text on the button
     * @return the basic setup for all buttons
     */
    private JButton getButtonUI(String tag){
        JButton button = new JButton();
        button.setText(tag);
        button.setBackground(Color.black);
        button.setForeground(Color.white);

        return button;
    }

    /**
     * @return the basic setup for column panel
     */
    private JPanel getPanel()
    {
        JPanel panel = new JPanel(new GridLayout(4,1,0,10));
        panel.setBackground(Color.darkGray);

        return panel;
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
        setResizable(false);
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
        buttonRandF.addActionListener(getOperationListener("r"));
        buttonRandI.addActionListener(getOperationListener("i"));
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
