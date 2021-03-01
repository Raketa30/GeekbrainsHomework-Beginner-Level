package ru.geekbrains.lesson8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private StringBuilder answer;

    private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
    private ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("Nashorn");

    private boolean pushedEqualButton = false;
    private boolean pushedActionButton = false;
    private boolean pushedPointButton = false;

    public ActionPanel(JTextField textField) {
        answer = new StringBuilder();

        setLayout(new BorderLayout());
        setBounds(0, 0, 100, 250);

        JPanel clearBtnPanel = new JPanel();
        JPanel actions = new JPanel();
        JPanel pointAndEqualPanel = new JPanel();

        add(clearBtnPanel, BorderLayout.NORTH);
        add(actions, BorderLayout.CENTER);
        add(pointAndEqualPanel, BorderLayout.SOUTH);

        actions.setLayout(new GridLayout(3, 2));
        actions.setPreferredSize(new Dimension(100, 150));

        clearBtnPanel.setLayout(new BorderLayout());
        clearBtnPanel.setPreferredSize(new Dimension(100, 50));

        pointAndEqualPanel.setLayout(new GridLayout(1, 2));
        pointAndEqualPanel.setPreferredSize(new Dimension(100, 50));

        JButton sum = new JButton("+");
        sum.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append("+");
            }
        });

        JButton subtract = new JButton("-");
        subtract.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append("-");
            }
        });

        JButton multiply = new JButton("*");
        multiply.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append("*");
            }
        });

        JButton divide = new JButton("/");
        divide.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append("/");
            }
        });

        JButton sqrt = new JButton("√");
        sqrt.addActionListener(e -> {
            pushedEqualButton = true;
            double digit = Double.parseDouble(textField.getText());
            double answer = Math.sqrt(digit);
            textField.setText(String.valueOf(answer));
        });

        JButton remainder = new JButton("%");
        remainder.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append("%");
            }
        });

        JButton pointBtn = new JButton(".");
        pointBtn.addActionListener(e -> {
            if (!pushedPointButton) {
                pushedPointButton = true;
                textField.setText(textField.getText() + ".");
            }
        });

        JButton eq = new JButton("=");
        eq.addActionListener(e -> {
            pushedEqualButton = true;
        });

        JButton clear = new JButton("C");
        clear.addActionListener(e -> {
            textField.setText("0");
            pushedActionButton = false;
            pushedPointButton = false;
            pushedEqualButton = false;
        });

        actions.add(sum);
        actions.add(subtract);
        actions.add(multiply);
        actions.add(divide);
        actions.add(remainder);
        actions.add(sqrt);

        pointAndEqualPanel.add(pointBtn);
        pointAndEqualPanel.add(eq);


        clearBtnPanel.add(clear, BorderLayout.CENTER);
    }

    public boolean isPushedEqualButton() {
        return pushedEqualButton;
    }

    public boolean isPushedActionButton() {
        return pushedActionButton;
    }

    public void setPushedActionButton(boolean pushedActionButton) {
        this.pushedActionButton = pushedActionButton;
    }

    public StringBuilder getAnswer() {
        return answer;
    }

    public ScriptEngine getScriptEngine() {
        return scriptEngine;
    }
}
