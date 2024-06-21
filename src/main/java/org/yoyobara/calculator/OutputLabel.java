package org.yoyobara.calculator;

import java.awt.Color;

import javax.swing.JLabel;

/**
 * OutputField
 */
public class OutputLabel extends JLabel {
    public OutputLabel() {
        super();
        setOpaque(true);
        setBackground(new Color(30, 30, 30));
        setFont(Calculator.FONT);
    }
}
