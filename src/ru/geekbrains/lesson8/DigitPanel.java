package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class DigitPanel extends JPanel {
    public DigitPanel(JTextField textField, ActionPanel actionPanel) {
        JPanel top = new JPanel();
        JPanel bottomZero = new JPanel();
        DigitButtonListener buttonListener = new DigitButtonListener(textField, actionPanel);

        setLayout(new BorderLayout());

        add(top, BorderLayout.CENTER);
        add(bottomZero, BorderLayout.SOUTH);

        top.setLayout(new GridLayout(3, 3));
        bottomZero.setLayout(new BorderLayout());

        for (int i = 9; i >= 1; i--) {
            JButton digit = new JButton(String.valueOf(i));
            digit.addActionListener(buttonListener);
            top.add(digit);
        }

        JButton zero = new JButton("0");
        zero.addActionListener(buttonListener);

        bottomZero.add(zero, BorderLayout.CENTER);
        bottomZero.setPreferredSize(new Dimension(200, 50));

    }
}
