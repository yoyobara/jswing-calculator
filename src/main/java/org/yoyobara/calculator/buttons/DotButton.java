package org.yoyobara.calculator.buttons;

import java.awt.event.ActionEvent;

import org.yoyobara.calculator.CalcLogic;

public class DotButton extends CalcButton {
    public DotButton(CalcLogic logicCtx) {
        super(".", logicCtx);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        logicCtx.addDotToBuffer();
    }
}
