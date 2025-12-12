package org.example;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JFrame {
    public JTextField screen = new JTextField(10);

    public JButton button_1 = new JButton("1");
    public JButton button_2 = new JButton("2");
    public JButton button_3 = new JButton("3");
    public JButton button_4 = new JButton("4");
    public JButton button_5 = new JButton("5");
    public JButton button_6 = new JButton("6");
    public JButton button_7 = new JButton("7");
    public JButton button_8 = new JButton("8");
    public JButton button_9 = new JButton("9");
    public JButton button_0 = new JButton("0");
    public JButton button_add = new JButton("+");
    public JButton button_substract = new JButton("-");
    public JButton button_divide = new JButton("/");
    public JButton button_multiply = new JButton("*");
    public JButton button_equal = new JButton("=");
    public JButton button_C = new JButton("C");
    public JButton button_backspace = new JButton("<-");

    public JPanel panelButtons = new JPanel(new GridLayout(5, 4));

    public CalculatorView() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.add("North", screen);

        panelButtons.add(button_9);
        panelButtons.add(button_8);
        panelButtons.add(button_7);
        panelButtons.add(button_divide);
        panelButtons.add(button_6);
        panelButtons.add(button_5);
        panelButtons.add(button_4);
        panelButtons.add(button_multiply);
        panelButtons.add(button_3);
        panelButtons.add(button_2);
        panelButtons.add(button_1);
        panelButtons.add(button_substract);
        panelButtons.add(button_C);
        panelButtons.add(button_0);
        panelButtons.add(button_backspace);
        panelButtons.add(button_add);
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(button_equal);

        panel.add("Center", panelButtons);
        setContentPane(panel);
        pack();
        setVisible(true);
    }
}
