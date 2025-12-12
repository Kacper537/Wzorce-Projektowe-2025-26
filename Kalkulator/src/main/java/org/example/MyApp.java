package org.example;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyApp extends JFrame {
    private JTextField screen;

    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = false;

    private JButton button_1 = new JButton("1");
    private JButton button_2 = new JButton("2");
    private JButton button_3 = new JButton("3");
    private JButton button_4 = new JButton("4");
    private JButton button_5 = new JButton("5");
    private JButton button_6 = new JButton("6");
    private JButton button_7 = new JButton("7");
    private JButton button_8 = new JButton("8");
    private JButton button_9 = new JButton("9");
    private JButton button_0 = new JButton("0");
    private JButton button_add = new JButton("+");
    private JButton button_substract = new JButton("-");
    private JButton button_divide = new JButton("/");
    private JButton button_multiply = new JButton("*");
    private JButton button_equal = new JButton("=");
    private JButton button_C = new JButton("C");
    private JButton button_backspace = new JButton("<-");

    public MyApp() {
        JPanel panel = new JPanel(new BorderLayout());
        screen = new JTextField(10);
        panel.add("North", screen);
        JPanel panelButtons = new JPanel(new GridLayout(5, 4));

        button_9.addActionListener(e -> screen.setText(screen.getText() + "9"));
        panelButtons.add(button_9);

        button_8.addActionListener(e -> screen.setText(screen.getText() + "8"));
        panelButtons.add(button_8);

        button_7.addActionListener(e -> screen.setText(screen.getText() + "7"));
        panelButtons.add(button_7);

        button_divide.addActionListener(e -> handleOperator("/"));
        panelButtons.add(button_divide);

        button_6.addActionListener(e -> screen.setText(screen.getText() + "6"));
        panelButtons.add(button_6);

        button_5.addActionListener(e -> screen.setText(screen.getText() + "5"));
        panelButtons.add(button_5);

        button_4.addActionListener(e -> screen.setText(screen.getText() + "4"));
        panelButtons.add(button_4);

        button_multiply.addActionListener(e -> handleOperator("*"));
        panelButtons.add(button_multiply);

        button_3.addActionListener(e -> screen.setText(screen.getText() + "3"));
        panelButtons.add(button_3);

        button_2.addActionListener(e -> screen.setText(screen.getText() + "2"));
        panelButtons.add(button_2);

        button_1.addActionListener(e -> screen.setText(screen.getText() + "1"));
        panelButtons.add(button_1);

        button_substract.addActionListener(e -> handleOperator("-"));
        panelButtons.add(button_substract);

        button_C.addActionListener(e -> {
            screen.setText("");
            firstNumber = 0;
            operator = "";
            startNewNumber = false;
        });
        panelButtons.add(button_C);

        button_0.addActionListener(e -> screen.setText(screen.getText() + "0"));
        panelButtons.add(button_0);

        button_backspace.addActionListener(e -> {
            String text = screen.getText();
            if (!text.isEmpty()) {
                screen.setText(text.substring(0, text.length() - 1));
            }
        });
        panelButtons.add(button_backspace);

        button_add.addActionListener(e -> handleOperator("+"));
        panelButtons.add(button_add);

        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());
        panelButtons.add(new JLabel());

        button_equal.addActionListener(e -> calculateResult());
        panelButtons.add(button_equal);

        panel.add("Center", panelButtons);
        setContentPane(panel);
        pack();
        setVisible(true);
    }

    private void handleOperator(String op) {
        String text = screen.getText();
        if (!text.isEmpty()) {
            double current = Double.parseDouble(text);
            if (!operator.isEmpty()) {
                switch (operator) {
                    case "+": firstNumber = firstNumber + current; break;
                    case "-": firstNumber = firstNumber - current; break;
                    case "*": firstNumber = firstNumber * current; break;
                    case "/":
                        if (current == 0) {
                            screen.setText("Błąd");
                            operator = "";
                            startNewNumber = false;
                            return;
                        } else {
                            firstNumber = firstNumber / current;
                        }
                        break;
                }
            } else {
                firstNumber = current;
            }

            operator = op;
            startNewNumber = true;
            screen.setText("");
        } else {
            operator = op;
        }
    }

    private void calculateResult() {
        if (operator.isEmpty() || screen.getText().isEmpty()) return;
        double secondNumber = Double.parseDouble(screen.getText());
        double result = 0;
        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/":
                if (secondNumber != 0) result = firstNumber / secondNumber;
                else {
                    screen.setText("Błąd");
                    return;
                }
                break;
        }
        screen.setText(String.valueOf(result));
        operator = "";
        startNewNumber = false;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MyApp();
            }
        });

    }
}
