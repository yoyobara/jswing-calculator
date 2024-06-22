package org.yoyobara.calculator;

/**
 * this contains the actual logic of the calculator.
 */
public class CalcLogic {

    private OutputLabel output;

    public CalcLogic(OutputLabel out) {
        this.output = out;
    }

    public void addDigitToBuffer(int number) {
        if (number > 9 || number < 0) {
            throw new IllegalArgumentException("bad digit: " + number);
        }

        output.append(Integer.toString(number));
    }

    public void addDotToBuffer() {
        if (!output.getText().contains(".")) 
            output.append(".");
    }

    public void performBinaryOperation(BinaryOperation binOp) {
        throw new UnsupportedOperationException("NOT IMPLEMENTED YET!!");
    }
}
