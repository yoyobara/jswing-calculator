package org.yoyobara.calculator;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Calculator
 */
public class Calculator extends JPanel {
    private JTextField outputField;
    private NumberButton[] numberButtons;
    private NumberButton zeroButton;

    private void addStuffToPanel() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints cons = new GridBagConstraints();

        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1.0; // Allow columns to grow horizontally
        cons.weighty = 1.0; // Allow rows to grow vertically
        cons.insets = new Insets(5, 5, 5, 5);

        // add the output field
        cons.gridx = 0;
        cons.gridy = 0;
        cons.gridwidth = 3;
        this.add(this.outputField, cons);

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
        cons.gridwidth = 2;
        this.add(this.zeroButton, cons);

        // cons.gridwidth = 1
    }

    public Calculator() {
        super();

        // style
        this.setBackground(new Color(30, 30, 30));

        // components
        this.outputField = new JTextField(30);
        this.numberButtons = new NumberButton[10];
        this.zeroButton = new NumberButton(0);

        for (int i = 0 ; i < 9 ; i++) {
            numberButtons[i] = new NumberButton(i + 1);
        }

        addStuffToPanel();
    }
}

class CalcButton extends JButton {
    public CalcButton(String content) {
        super();

        // style 
        setBackground(Color.ORANGE);
        setText(content);
    }
}

class NumberButton extends CalcButton {
    int number;

    public NumberButton(int number) {
        super(Integer.toString(number));
        this.number = number;
    }
}
