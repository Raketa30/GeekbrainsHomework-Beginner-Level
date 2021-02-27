package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {

    private double temporary;

    public ActionPanel(JTextField textField) {
        setLayout(new BorderLayout());
        setBounds(0,0, 100, 250);

        JPanel clearBtnPanel = new JPanel();
        JPanel actions = new JPanel();
        JPanel signEqualPanel = new JPanel();

        add(clearBtnPanel, BorderLayout.NORTH);
        add(actions, BorderLayout.CENTER);
        add(signEqualPanel, BorderLayout.SOUTH);

        actions.setLayout(new GridLayout(3, 2));
        actions.setPreferredSize(new Dimension(100, 150));

        clearBtnPanel.setLayout(new BorderLayout());
        clearBtnPanel.setPreferredSize(new Dimension(100, 50));

        signEqualPanel.setLayout(new BorderLayout());
        signEqualPanel.setPreferredSize(new Dimension(100, 50));

        JButton summ = new JButton("+");
        summ.addActionListener(e -> {
            if(temporary == 0) {
                temporary = Double.parseDouble(textField.getText());
                textField.setText("");

            } else {
                double current = Double.parseDouble(textField.getText());
                temporary = temporary + current;
                textField.setText(String.valueOf(temporary));
            }
        });

        JButton substruct = new JButton("-");
        substruct.addActionListener(e -> {
            if(temporary == 0) {
                temporary = Double.parseDouble(textField.getText());
                textField.setText("");
            } else {
                double current = Double.parseDouble(textField.getText());
                temporary = temporary - current;
                textField.setText(String.valueOf(temporary));
            }
        });

        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton sqrt = new JButton("√");
        JButton remainder = new JButton("%");

        JButton eq = new JButton("=");
        eq.addActionListener(e -> {
            textField.setText(String.valueOf(temporary));
        });

        JButton clear = new JButton("C");
        clear.addActionListener(e -> {
            temporary = 0;
            textField.setText("");
        });


        actions.add(summ);
        actions.add(substruct);
        actions.add(multiply);
        actions.add(divide);
        actions.add(remainder);
        actions.add(sqrt);


        signEqualPanel.add(eq, BorderLayout.CENTER);
        clearBtnPanel.add(clear, BorderLayout.CENTER);
    }
}
