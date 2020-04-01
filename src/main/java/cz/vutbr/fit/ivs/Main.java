package cz.vutbr.fit.ivs;

import javax.swing.*;

public class Main {
    public static void main(String [] args) {
        JFrame frame = new JFrame("JCalc");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,647);         //golden ratio
        Calculator calculator = new Calculator();
        frame.getContentPane().add(calculator);
        frame.setVisible(true);
    }
}
