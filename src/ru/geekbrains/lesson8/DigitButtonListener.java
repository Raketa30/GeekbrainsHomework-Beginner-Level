package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DigitButtonListener implements ActionListener {
    private final JTextField textField;
    private StringBuilder builder;
    private ActionPanel actionPanel;

    public DigitButtonListener(JTextField textField, ActionPanel actionPanel) {
        this.textField = textField;
        this.actionPanel = actionPanel;
        this.builder = new StringBuilder();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!actionPanel.isPushedEqualButton()) { // что бы ответ был неизменным
            if (textField.getText().equals("0") && !actionPanel.isPushedActionButton()) { //что бы убрать ноль
                textField.setText("");
            }

            if (actionPanel.isPushedActionButton()) {//обнулить текстфилд плосле нажатия кнопки действия

                textField.setText("");
                actionPanel.setPushedActionButton(false);
            }

            builder.append(textField.getText());
            builder.append(((JButton) e.getSource()).getText());

            textField.setText(builder.toString());

            builder.setLength(0);

        }

    }
}
