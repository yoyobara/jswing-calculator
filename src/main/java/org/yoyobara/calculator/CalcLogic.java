package org.yoyobara.calculator;

/**
 * this contains the actual logic of the calculator.
 */
public class CalcLogic {

    private String buffer = "";

    public CalcLogic() {
    }

    public void addDigitToBuffer(int number) {
        if (number > 9 || number < 0) {
            throw new IllegalArgumentException("bad digit: " + number);
        }

        buffer += number;
    }

    public void addDotToBuffer() {
        if (buffer.contains(".")) {
            throw new IllegalArgumentException("dot already there...");
        }

        buffer += ".";
    }

    public void performBinaryOperation(BinaryOperation binOp) {
    }
}
