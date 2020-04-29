package cz.vutbr.fit.ivs;

import javax.swing.*;

public class HelpBox extends JFrame {
    private JPanel HelpBoxPanel;
    private JTextArea TextShouldHelp;

    public HelpBox() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setContentPane(HelpBoxPanel);
        setVisible(true);
    }
}
