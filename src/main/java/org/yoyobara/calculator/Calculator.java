package org.yoyobara.calculator;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.JPanel;

import org.yoyobara.calculator.buttons.*;

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

    private BinaryOperatorButton addButton;
    private BinaryOperatorButton subtractButton;
    private BinaryOperatorButton multiplyButton;
    private BinaryOperatorButton divideButton;

    private UnaryOperatorButton sinButton;
    private UnaryOperatorButton cosButton;
    private UnaryOperatorButton tanButton;
    private UnaryOperatorButton sqrtButton;

    private ClearButton clearButton;

    private CalcLogic logic;

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
        cons.gridwidth = 5;
        this.add(this.outputLabel, cons);

        cons.gridwidth = 1;

        // add 1 - 9 number buttons
        for (int i = 0 ; i < 9 ; i++) {
            cons.gridx = i % 3;
            cons.gridy = 2 + i / 3;

            this.add(this.numberButtons[i], cons);
        }

        // add zero
        cons.gridx = 0;
        cons.gridy = 5;
        this.add(this.zeroButton, cons);

        // add dot
        cons.gridx = 1;
        this.add(this.dotButton, cons);

        // add equal
        cons.gridx = 2;
        this.add(this.equalButton, cons);
    
        // add operations
        cons.gridx = 3;
        cons.gridy = 2;
        this.add(this.addButton, cons);

        cons.gridy++;
        this.add(this.subtractButton, cons);

        cons.gridy++;
        this.add(this.multiplyButton, cons);

        cons.gridy++;
        this.add(this.divideButton, cons);
        
        // add clear button
        cons.gridx = 4;
        cons.gridy = 1;
        cons.gridheight = 5;
        this.add(this.clearButton, cons);

        // add unary stuff
        cons.gridy = 1;
        cons.gridx = 0;
        cons.gridheight = 1;

        this.add(this.sqrtButton, cons);
        cons.gridx++;

        this.add(this.sinButton, cons);
        cons.gridx++;

        this.add(this.cosButton, cons);
        cons.gridx++;

        this.add(this.tanButton, cons);
    }

    public void initSpecialButtons() {

        // basic binOps
        this.addButton = new BinaryOperatorButton("+", logic, (a, b) -> a + b);
        this.subtractButton = new BinaryOperatorButton("-", logic, (a, b) -> a - b);
        this.multiplyButton = new BinaryOperatorButton("×", logic, (a, b) -> a * b);
        this.divideButton = new BinaryOperatorButton("÷", logic, (a, b) -> a / b);

        // more operators
        this.sinButton = new UnaryOperatorButton("sin", logic, Math::sin);
        this.cosButton = new UnaryOperatorButton("cos", logic, Math::cos);
        this.tanButton = new UnaryOperatorButton("tan", logic, Math::tan);
        this.sqrtButton = new UnaryOperatorButton("√", logic, Math::sqrt);

        // action buttons

        this.dotButton = new CalcButton(".", logic) {
            public void actionPerformed(ActionEvent arg0) {
                logic.addDotToBuffer();
            }
        };

        this.equalButton = new CalcButton("=", logic) {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                logic.performEqualButton();
            }
        };

        this.clearButton = new ClearButton("AC", logic);
        this.logic.setClearButton(this.clearButton);
    }

    public Calculator() {
        super();

        // output component, clear button
        this.outputLabel = new OutputLabel();

        // logic
        this.logic = new CalcLogic(outputLabel);

        // buttons
        this.numberButtons = new NumberButton[9];
        for (int i = 0 ; i < 9 ; i++) {
            numberButtons[i] = new NumberButton(i + 1, logic);
        }

        this.zeroButton = new NumberButton(0, logic);
        initSpecialButtons();

        addStuffToPanel();
    }
}
