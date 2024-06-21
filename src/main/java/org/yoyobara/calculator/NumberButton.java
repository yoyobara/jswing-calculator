package org.yoyobara.calculator;

class NumberButton extends CalcButton {
    private int number;

    public NumberButton(int number) {
        super(Integer.toString(number));
        this.number = number;
    }

    /*
     * returns the number of the button
     */
    public int getNumber() {
        return this.number;
    }
}
