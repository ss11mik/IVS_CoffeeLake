import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;

public class Calculator extends JTextField {

    private int operation = Operations.NONE;

    private double memory;

    public Calculator() {
        super();
    }

    public Calculator(int cols) {
        super(cols);
    }

    public double getValue() {
        final String text = getText();
        if (text == null || text.length() == 0) {
            return 0;
        }
        return Double.parseDouble(text);
    }

    public void clear() {
        setText("");
    }

    public void clearAndSave() {
        memory = getValue();
        clear();
    }

    public void clearAndCalculateToMemory() {
        memory = calculate();
        clear();
    }

    public void setText(double d) {
        super.setText(String.valueOf(d));
    }

    public double calculate() {
        return MathLib.calculate(memory, getValue(), operation);
    }

    public void calculateAndSetText() {
        setText(calculate());
    }

    protected Document createDefaultModel() {
        return new DoubleDocument();
    }

    class DoubleDocument extends PlainDocument {

        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            if (str != null) {
                try {
                    Double.parseDouble(str);
                    super.insertString(offs, str, a);
                }
                catch (NumberFormatException ex) {
                    switch (str.charAt(0)) {
                        case '=':
                            calculateAndSetText();
                            operation = Operations.NONE;
                            break;
                        case '+':
                            clearAndCalculateToMemory();
                            operation = Operations.ADD;
                            break;
                        case '-':
                            clearAndCalculateToMemory();
                            operation = Operations.SUB;
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