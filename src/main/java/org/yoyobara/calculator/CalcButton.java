package org.yoyobara.calculator;

import java.awt.Font;

import javax.swing.JButton;

class CalcButton extends JButton {

    private static Font FONT = new Font("Arial", Font.BOLD, 30);

    public CalcButton(String content) {
        super();
        setText(content);
        setFont(FONT);
    }
}
