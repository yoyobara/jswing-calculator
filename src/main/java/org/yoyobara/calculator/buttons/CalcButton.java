package org.yoyobara.calculator.buttons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.yoyobara.calculator.CalcLogic;
import org.yoyobara.calculator.Calculator;

public class CalcButton extends JButton implements ActionListener {
    protected CalcLogic logicCtx;

    public CalcButton(String content, CalcLogic logicCtx) {
        super();
        this.logicCtx = logicCtx;

        setText(content);
        setFont(Calculator.FONT);
        addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
}
