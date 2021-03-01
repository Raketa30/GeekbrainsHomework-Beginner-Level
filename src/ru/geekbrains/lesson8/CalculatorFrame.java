package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator v. 1.0.1b");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBounds(300, 300, 300, 300);
        setResizable(false);

        CalculatorScreen screen = new CalculatorScreen();
        Keyboard keyboard = new Keyboard(screen.getTextField());

        add(screen, BorderLayout.NORTH);
        add(keyboard, BorderLayout.CENTER);


        setVisible(true);
    }


}
