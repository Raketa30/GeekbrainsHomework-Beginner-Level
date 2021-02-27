package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class Keyboard extends JPanel {
    public Keyboard(JTextField textField) {

        ActionPanel actionPanel = new ActionPanel(textField);
        DigitPanel digitPanel = new DigitPanel(textField);
        actionPanel.setPreferredSize(new Dimension(100, 250));

        setLayout(new BorderLayout());
        add(digitPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.EAST);
    }
}
