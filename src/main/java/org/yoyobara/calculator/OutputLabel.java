package org.yoyobara.calculator;

import java.awt.Color;
import java.awt.Dimension;

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
        setPreferredSize(new Dimension(0, 64));
    }
}
