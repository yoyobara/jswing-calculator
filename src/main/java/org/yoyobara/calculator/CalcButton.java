package org.yoyobara.calculator;

import javax.swing.JButton;

class CalcButton extends JButton {


    public CalcButton(String content) {
        super();
        setText(content);
        setFont(Calculator.FONT);
    }
}
