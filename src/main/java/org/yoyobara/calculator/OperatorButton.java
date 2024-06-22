package org.yoyobara.calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperatorButton extends CalcButton implements ActionListener {

    private BinaryOperation binOp;

	public OperatorButton(String content, CalcLogic logicCtx, BinaryOperation binOp) {
		super(content, logicCtx);
        this.binOp = binOp;

        addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
        logicCtx.performBinaryOperation(binOp);
	}
}
