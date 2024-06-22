package org.yoyobara.calculator;

import javax.swing.JButton;

class CalcButton extends JButton {
    protected CalcLogic logicCtx;

    public CalcButton(String content, CalcLogic logicCtx) {
        super();
        this.logicCtx = logicCtx;

        setText(content);
        setFont(Calculator.FONT);
    }
}
