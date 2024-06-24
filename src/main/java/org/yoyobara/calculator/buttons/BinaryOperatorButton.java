package org.yoyobara.calculator.buttons;

import org.yoyobara.calculator.BinaryOperation;
import org.yoyobara.calculator.CalcLogic;

import java.awt.event.ActionEvent;

public class BinaryOperatorButton extends CalcButton {

    private BinaryOperation binOp;

	public BinaryOperatorButton(String content, CalcLogic logicCtx, BinaryOperation binOp) {
		super(content, logicCtx);
        this.binOp = binOp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.performOperation(binOp);
	}
}
