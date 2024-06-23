package org.yoyobara.calculator.buttons;

import org.yoyobara.calculator.CalcLogic;

import java.awt.event.ActionEvent;

public class NumberButton extends CalcButton {
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.addDigitToBuffer(this.number);
	}
}
