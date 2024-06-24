package org.yoyobara.calculator;

import java.util.Optional;

import org.yoyobara.calculator.buttons.ClearButton;

/**
 * this contains the actual logic of the calculator.
 */
public class CalcLogic {

    private OutputLabel output;
    private ClearButton clearButton;

    private Optional<Pending> pending;

    public CalcLogic(OutputLabel out) {
        this.output = out;
        this.pending = Optional.empty();
    }

    public void setClearButton(ClearButton c) {
        this.clearButton = c;
    }

    public void addDigitToBuffer(int number) {
        if (number > 9 || number < 0) {
            throw new IllegalArgumentException("bad digit: " + number);
        }

        output.append(Integer.toString(number));
        clearButton.setCE();
    }

    public void addDotToBuffer() {
        if (!output.getText().contains(".")) {
            output.append(".");
            clearButton.setCE();
        }
    }

    public void performOperation(BinaryOperation binOp) {

        if (this.pending.isEmpty()) {
            this.pending = Optional.of(new Pending(takeNumberFromOutput(), binOp));
        } else {
            Pending currentPending = this.pending.get();
            double currentNumber = takeNumberFromOutput();

            double result = currentPending.pendingOperation.performOperation(currentPending.pendingNumber, currentNumber);
            this.pending = Optional.of(new Pending(result, binOp));
        }
    }

    public void performOperation(UnaryOperation unOp) {
        if (output.isEmpty())
            return;

        performEqualButton(); // in case something is pending
        this.output.set(unOp.performOperation(this.output.get()));
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

    public void performClear() {
        if (clearButton.isAC()) {
            this.pending = Optional.empty();
        } else {
            this.output.clear();
            clearButton.setAC();
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
