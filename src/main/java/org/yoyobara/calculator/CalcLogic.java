package org.yoyobara.calculator;

import java.util.Optional;
import java.util.OptionalDouble;

/**
 * this contains the actual logic of the calculator.
 */
public class CalcLogic {

    private OutputLabel output;

    private Optional<Pending> pending;

    public CalcLogic(OutputLabel out) {
        this.output = out;
        this.pending = Optional.empty();
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

        if (this.pending.isEmpty()) {
            this.pending = Optional.of(new Pending(takeNumberFromOutput(), binOp));
        } else {
            Pending currentPending = this.pending.get();
            double currentNumber = takeNumberFromOutput();

            double result = currentPending.pendingOperation.performOperation(currentPending.pendingNumber, currentNumber);
            this.pending = Optional.of(new Pending(result, binOp));
        }
    }

    public void performEqualButton() {
        if (this.pending.isPresent()) {
            Pending currentPending = this.pending.get();
            double currentNumber = takeNumberFromOutput();

            double result = currentPending.pendingOperation.performOperation(currentPending.pendingNumber, currentNumber);
            this.output.set(result);
            this.pending = Optional.empty();
        }
    }

    private double takeNumberFromOutput() {
        double val = output.get();
        output.clear();
        return val;
    }
}
class Pending {
    double pendingNumber;
    BinaryOperation pendingOperation;

    Pending(double num, BinaryOperation op) {
        this.pendingOperation = op;
        this.pendingNumber = num;
    }
}
