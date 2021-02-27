package ru.geekbrains.lesson8;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        ImageIcon icon = new ImageIcon("ru/geekbrains/lesson8/calc.png");
        setIconImage(icon.getImage());
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setBounds(0, 0, 300, 300);
        setResizable(false);

        CalculatorScreen screen = new CalculatorScreen();
        Keyboard keyboard = new Keyboard(screen.getTextField());

        add(screen, BorderLayout.NORTH);
        add(keyboard, BorderLayout.CENTER);


        setVisible(true);
    }


}
