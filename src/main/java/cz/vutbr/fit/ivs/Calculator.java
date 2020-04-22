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

/**
 * Class extending {@link javax.swing.JTextField} and providing the display field
 * Most of the logic happens here. This class encloses memory, last pressed operation and so on
 * It also provides facade methods for manipulating with the display itself
 *
 * @author Ondřej Mikula, Marek Lohn, René Szotkowski
 */
public class Calculator extends JTextField {

    private int operation = Operations.NONE;
    private double memory;
    private final NumberFormat format;

    /**
     * Constructor
     */
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

    /**
     * @return the displayed text
     */
    public String getText() {
        return String.valueOf(getValue());
    }

    /**
     * @return current value on display
     */
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

    /**
     * Clears the display
     */
    public void clear() {
        super.setText("");
    }

    /**
     * Clears display, last operation and memory
     */
    public void reset() {
        clear();
        memory = 0;
        operation = Operations.NONE;
    }

    /**
     * saves displayed value to memory and then clears display
     */
    public void clearAndSave() {
        memory = getValue();
        clear();
    }

    /**
     * does the calculation to memory and then clears display
     */
    public void clearAndCalculateToMemory() {
        memory = calculate();
        clear();
    }

    public void add(String text) {
        try {
            getDocument().insertString(super.getText().length(), text, null);
        }
        catch (BadLocationException e) {
            //TODO
        }
    }

    public void setValue(double d) {
        super.setText(format.format(d));
    }

    /**
     * Does the operation specified at operation with memory and displayed value
     * @return result of the operation
     */
    public double calculate() {
        return MathLib.calculate(memory, getValue(), operation);
    }

    public void calculateAndSetText() {
        setValue(calculate());
    }

    protected Document createDefaultModel() {
        return new DoubleDocument();
    }

    /**
     * Document capturing inserted Strings.
     * Decides, whether the increment is double, in that case it appends it to displayed value
     * If not, checks for characters triggering operations
     */
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
                        case '%':
                            clearAndCalculateToMemory();
                            operation = Operations.MOD;
                            break;
                        case '^':
                            clearAndCalculateToMemory();
                            operation = Operations.POW;
                            break;
                        case '#':
                            clearAndCalculateToMemory();
                            operation = Operations.SQRT;
                            break;
                        default:
                    }
                }
            }
        }
    }
}