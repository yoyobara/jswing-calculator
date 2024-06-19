package org.yoyobara.calculator;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame window = new JFrame();
        Calculator calc = new Calculator();

        window.add(calc);

        window.setSize(500, 500);
        window.setTitle("jswing calculator");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null); // Center the frame
        window.setVisible(true);
    }
}
