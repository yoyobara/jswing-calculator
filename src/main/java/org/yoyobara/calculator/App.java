package org.yoyobara.calculator;

import javax.swing.JFrame;

public class App {

    public static void main(String[] args) {
        JFrame window = new JFrame();

        window.add(new Calculator());

        window.setSize(500, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // Center the frame
        window.setVisible(true);
    }
}
