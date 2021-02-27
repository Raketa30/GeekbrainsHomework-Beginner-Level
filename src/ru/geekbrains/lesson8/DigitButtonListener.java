package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private final JTextField textField;
    private StringBuilder builder;

    public DigitButtonListener(JTextField textField) {
        this.textField = textField;
        this.builder = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        builder.append(textField.getText());
        builder.append(((JButton) e.getSource()).getText());

        textField.setText(builder.toString());
        builder.setLength(0);
    }
}
