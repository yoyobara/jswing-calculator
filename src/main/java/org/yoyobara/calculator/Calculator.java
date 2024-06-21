package org.yoyobara.calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JPanel;

/**
 * Calculator
 */
public class Calculator extends JPanel {

    public static Font FONT = new Font("Arial", Font.BOLD, 30);

    private OutputLabel outputLabel;

    private NumberButton[] numberButtons;
    private NumberButton zeroButton;

    private CalcButton dotButton;
    private CalcButton equalButton;

    private CalcButton addButton;
    private CalcButton subtractButton;
    private CalcButton multiplyButton;
    private CalcButton divideButton;

    private void addStuffToPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();
        cons.weightx = 1.0;
        cons.weighty = 1.0;
        cons.insets = new Insets(5, 5, 5, 5);
        cons.fill = GridBagConstraints.BOTH;

        // add the output field
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 4;
        this.add(this.outputLabel, cons);

        cons.gridwidth = 1;

        // add 1 - 9 number buttons
        for (int i = 0 ; i < 9 ; i++) {
            cons.gridx = i % 3;
            cons.gridy = 1 + i / 3;

            this.add(this.numberButtons[i], cons);
        }

        // add zero
        cons.gridx = 0;
        cons.gridy = 4;
        this.add(this.zeroButton, cons);

        // add dot
        cons.gridx = 1;
        this.add(this.dotButton, cons);

        // add equal
        cons.gridx = 2;
        this.add(this.equalButton, cons);
    
        // add operations
        cons.gridx = 3;
        cons.gridy = 1;
        this.add(this.addButton, cons);

        cons.gridy++;
        this.add(this.subtractButton, cons);

        cons.gridy++;
        this.add(this.multiplyButton, cons);

        cons.gridy++;
        this.add(this.divideButton, cons);
    }

    public Calculator() {
        super();

        // components
        this.outputLabel = new OutputLabel();

        // buttons
        this.numberButtons = new NumberButton[9];
        this.zeroButton = new NumberButton(0);

        this.dotButton = new CalcButton(".");
        this.equalButton = new CalcButton("=");

        this.addButton = new CalcButton("+");
        this.subtractButton = new CalcButton("-");
        this.multiplyButton = new CalcButton("*");
        this.divideButton = new CalcButton("/");

        for (int i = 0 ; i < 9 ; i++) {
            numberButtons[i] = new NumberButton(i + 1);
        }

        addStuffToPanel();
    }
}
