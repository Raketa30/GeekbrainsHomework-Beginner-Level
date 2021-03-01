package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class ActionPanel extends JPanel {
    private final StringBuilder answer;

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
                answer.append(textField.getText());
                String current = process(answer.toString());
                textField.setText(current);
                answer.setLength(0);
                answer.append(current).append(" + ");
            } else {
                answer.replace(answer.length() - 3, answer.length() - 1, (" + "));
            }
        });

        JButton subtract = new JButton("-");
        subtract.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append(textField.getText());
                String current = process(answer.toString());
                textField.setText(current);
                answer.setLength(0);
                answer.append(current).append(" - ");
            } else {
                answer.replace(answer.length() - 3, answer.length() - 1, (" - "));
            }
        });

        JButton multiply = new JButton("*");
        multiply.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append(textField.getText());
                String current = process(answer.toString());
                textField.setText(current);
                answer.setLength(0);
                answer.append(current).append(" * ");
            } else {
                answer.replace(answer.length() - 3, answer.length() - 1, (" * "));
            }
        });

        JButton divide = new JButton("/");
        divide.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append(textField.getText());
                String current = process(answer.toString());
                textField.setText(current);
                answer.setLength(0);
                answer.append(current).append(" / ");
            } else {
                answer.replace(answer.length() - 3, answer.length() - 1, (" / "));
            }
        });

        JButton sqrt = new JButton("√");
        sqrt.addActionListener(e -> {
            answer.append(textField.getText());
            double digit = Double.parseDouble(process(answer.toString()));
            double sq = Math.sqrt(digit);
            textField.setText(filter(sq));
            answer.setLength(0);
        });

        JButton remainder = new JButton("%");
        remainder.addActionListener(e -> {
            if (!isPushedActionButton()) {
                pushedActionButton = true;
                answer.append(textField.getText());
                String current = process(answer.toString());
                textField.setText(current);
                answer.setLength(0);
                answer.append(current).append(" % ");
            } else {
                answer.replace(answer.length() - 3, answer.length() - 1, (" % "));
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
            if (!pushedEqualButton) {
                answer.append(textField.getText());
                textField.setText(process(answer.toString()));
                answer.setLength(0);
                pushedEqualButton = true;
            }
        });

        JButton clear = new JButton("C");
        clear.addActionListener(e -> {
            textField.setText("0");
            answer.setLength(0);
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

    private String process(String text) {
        System.out.println(text);
        String[] processArr = text.split(" ");

        if (processArr.length == 3) {
            return calculate(processArr[0], processArr[1], processArr[2]);
        }

        return processArr[0];
    }

    private String calculate(String a, String action, String b) {
        double number = 0;

        switch (action) {
            case ("+"):
                number = Double.parseDouble(a) + Double.parseDouble(b);
                break;

            case ("-"):
                number = Double.parseDouble(a) - Double.parseDouble(b);
                break;

            case ("*"):
                number = Double.parseDouble(a) * Double.parseDouble(b);
                break;

            case ("/"):
                if (Double.parseDouble(b) == 0) {
                    pushedPointButton = true;
                    pushedEqualButton = true;
                    return "Err";
                }
                number = Double.parseDouble(a) / Double.parseDouble(b);
                break;

            case ("%"):
                number = Double.parseDouble(a) % Double.parseDouble(b);
                break;
        }

        return filter(number);
    }

    private String filter(double number) {
        if (number * 10 % 10 == 0) {
            return String.valueOf((long) number);

        } else {
            return String.valueOf(number);
        }
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

    public void setPushedPointButton(boolean pushedPointButton) {
        this.pushedPointButton = pushedPointButton;
    }
}
