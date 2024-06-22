package org.yoyobara.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NumberButton extends CalcButton implements ActionListener {
    private int number;

    public NumberButton(int number, CalcLogic logicCtx) {
        super(Integer.toString(number), logicCtx);
        this.number = number;

        this.addActionListener(this);
    }

    /*
     * returns the number of the button
     */
    public int getNumber() {
        return this.number;
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.addDigitToBuffer(this.number);
	}
}
