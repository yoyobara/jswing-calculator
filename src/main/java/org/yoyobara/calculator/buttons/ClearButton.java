package org.yoyobara.calculator.buttons;

import java.awt.event.ActionEvent;

import org.yoyobara.calculator.CalcLogic;

public class ClearButton extends CalcButton {

    public ClearButton(String content, CalcLogic logicCtx) {
		super("AC", logicCtx);
	}

    public void setAC() {
        setText("AC");
    }

    public void setCE() {
        setText("CE");
    }

    public boolean isAC() {
        return this.getText() == "AC";
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        logicCtx.performClear();
    }

}
