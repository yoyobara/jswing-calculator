package org.yoyobara.calculator.buttons;

import java.awt.event.ActionEvent;

import org.yoyobara.calculator.CalcLogic;

public class EqualsButton extends CalcButton {

	public EqualsButton(CalcLogic logicCtx) {
		super("=", logicCtx);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.performEqualButton();
	}

}
