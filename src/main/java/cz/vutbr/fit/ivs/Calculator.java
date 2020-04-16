package cz.vutbr.fit.ivs;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.text.ParseException;


public class Calculator extends JTextField {

    private int operation = Operations.NONE;
    private double memory;
    private final NumberFormat format;

    public Calculator() {
        super();
        addActionListener(listener);
        format = NumberFormat.getNumberInstance(getLocale());
    }

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            calculateAndSetText();
        }
    };

    public String getText() {
        return String.valueOf(getValue());
    }

    public double getValue() {
        final String text = super.getText();
        if (text == null || text.length() == 0) {
            return 0;
        }
        try {
            return format.parse(text).doubleValue();
        }
        catch (ParseException e) {
            return 0;
        }
    }

    public void clear() {
        setText("");
    }

    public void reset() {
        clear();
        memory = 0;
        operation = Operations.NONE;
    }

    public void clearAndSave() {
        memory = getValue();
        clear();
    }

    public void clearAndCalculateToMemory() {
        memory = calculate();
        clear();
    }

    public void setText(String text) {
        if (text.isEmpty())
            super.setText("");
        else
            setValue(Double.parseDouble(text));
    }

    public void setValue(double d) {
        super.setText(format.format(d));
    }

    public double calculate() {
        return MathLib.calculate(memory, getValue(), operation);
    }

    public void calculateAndSetText() {
        setValue(calculate());
    }

    protected Document createDefaultModel() {
        return new DoubleDocument();
    }

    class DoubleDocument extends PlainDocument {

        public void insertString(int offset, String string, AttributeSet attributeSet) throws BadLocationException {
            if (string != null) {
                try {
                    format.parse(string);
                    super.insertString(offset, string, attributeSet);
                }
                catch (ParseException e) {
                    switch (string.charAt(0)) {
                        case '.':
                            super.insertString(offset, string, attributeSet);
                            break;
                   /*     case '=':
                            calculateAndSetText();
                            break;*/
                        case '+':
                            clearAndCalculateToMemory();
                            operation = Operations.ADD;
                            break;
                        case '-':
                          /*  if (getValue() != 0) {        //TODO when user wants to switch sign? special button
                                setText(-1 * getValue());
                            }
                            else {*/
                                clearAndCalculateToMemory();
                                operation = Operations.SUB;
                        //    }
                            break;
                        case '*':
                            clearAndCalculateToMemory();
                            operation = Operations.MUL;
                            break;
                        case '/':
                            clearAndCalculateToMemory();
                            operation = Operations.DIV;
                            break;
                        case '!':
                            operation = Operations.FACT;
                            calculateAndSetText();
                            break;
                        default:
                    }
                }
            }
        }
    }
}