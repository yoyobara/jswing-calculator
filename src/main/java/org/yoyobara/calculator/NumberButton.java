package org.yoyobara.calculator;

class NumberButton extends CalcButton {
    private int number;

    public NumberButton(int number, CalcLogic logicCtx) {
        super(Integer.toString(number), logicCtx);
        this.number = number;
    }

    /*
     * returns the number of the button
     */
    public int getNumber() {
        return this.number;
    }
}
