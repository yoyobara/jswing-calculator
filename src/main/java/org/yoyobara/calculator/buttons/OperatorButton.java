package org.yoyobara.calculator.buttons;

import org.yoyobara.calculator.BinaryOperation;
import org.yoyobara.calculator.CalcLogic;

import java.awt.event.ActionEvent;

public class OperatorButton extends CalcButton {

    private BinaryOperation binOp;

	public OperatorButton(String content, CalcLogic logicCtx, BinaryOperation binOp) {
		super(content, logicCtx);
        this.binOp = binOp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.performBinaryOperation(binOp);
	}
}
