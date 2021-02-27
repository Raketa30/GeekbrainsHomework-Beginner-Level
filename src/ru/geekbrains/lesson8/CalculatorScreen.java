package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class CalculatorScreen extends JPanel{
    private final JTextField textField;

    public CalculatorScreen() {
        setLayout(new BorderLayout());

        Font font = new Font("Roboto", Font.BOLD, 20);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 50));
        textField.setHorizontalAlignment(JTextField.RIGHT);
        textField.setEditable(false);
        textField.setFont(font);

        add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }


}
