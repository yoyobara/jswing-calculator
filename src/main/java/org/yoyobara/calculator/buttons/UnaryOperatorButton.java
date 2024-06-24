
package org.yoyobara.calculator.buttons;

import org.yoyobara.calculator.CalcLogic;
import org.yoyobara.calculator.UnaryOperation;

import java.awt.event.ActionEvent;

public class UnaryOperatorButton extends CalcButton {

    private UnaryOperation unOp;

	public UnaryOperatorButton(String content, CalcLogic logicCtx, UnaryOperation unOp) {
		super(content, logicCtx);
        this.unOp = unOp;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.performOperation(unOp);
	}
}
