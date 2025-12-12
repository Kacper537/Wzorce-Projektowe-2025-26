package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalculatorController {
    private final CalculatorModel model;
    private final CalculatorView view;
    private final MyGraphicsView graphicsView;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.graphicsView = new MyGraphicsView();
        JFrame frame = new JFrame("Widok graficzny");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphicsView);
        frame.setSize(300, 150);
        frame.setVisible(true);

        view.button_0.addActionListener(this::buttonPressed);
        view.button_1.addActionListener(this::buttonPressed);
        view.button_2.addActionListener(this::buttonPressed);
        view.button_3.addActionListener(this::buttonPressed);
        view.button_4.addActionListener(this::buttonPressed);
        view.button_5.addActionListener(this::buttonPressed);
        view.button_6.addActionListener(this::buttonPressed);
        view.button_7.addActionListener(this::buttonPressed);
        view.button_8.addActionListener(this::buttonPressed);
        view.button_9.addActionListener(this::buttonPressed);
        view.button_add.addActionListener(this::operatorPressed);
        view.button_substract.addActionListener(this::operatorPressed);
        view.button_multiply.addActionListener(this::operatorPressed);
        view.button_divide.addActionListener(this::operatorPressed);
        view.button_equal.addActionListener(this::equalPressed);
        view.button_C.addActionListener(this::clearPressed);
        view.button_backspace.addActionListener(this::backspacePressed);
    }

    private void buttonPressed(ActionEvent e) {
        String btn = e.getActionCommand();
        view.screen.setText(view.screen.getText() + btn);
    }

    private void operatorPressed(ActionEvent e) {
        String op = e.getActionCommand();
        String text = view.screen.getText();
        if (!text.isEmpty()) {
            double current = Double.parseDouble(text);
            if (!model.getOperator().isEmpty()) {
                current = model.calculate(model.getFirstNumber(), current, model.getOperator());
                view.screen.setText(String.valueOf(current));
                model.setFirstNumber(current);
            } else {
                model.setFirstNumber(current);
            }
            model.setOperator(op);
            model.setStartNewNumber(true);
            view.screen.setText("");
        }
    }

    private void equalPressed(ActionEvent e) {
        if (model.getOperator().isEmpty() || view.screen.getText().isEmpty()) return;
        double secondNumber = Double.parseDouble(view.screen.getText());
        try {
            double result = model.calculate(model.getFirstNumber(), secondNumber, model.getOperator());
            view.screen.setText(String.valueOf(result));
            graphicsView.setText(String.valueOf(result));
            model.setFirstNumber(result);
            model.setOperator("");
        } catch (ArithmeticException ex) {
            view.screen.setText("Błąd");
        }
        model.setStartNewNumber(false);
    }

    private void clearPressed(ActionEvent e) {
        view.screen.setText("");
        model.setFirstNumber(0);
        model.setOperator("");
        model.setStartNewNumber(false);
    }

    private void backspacePressed(ActionEvent e) {
        String text = view.screen.getText();
        if (!text.isEmpty()) {
            view.screen.setText(text.substring(0, text.length() - 1));
        }
    }

    public static void main(String[] args) {
        CalculatorModel model = new CalculatorModel();
        CalculatorView view = new CalculatorView();
        new CalculatorController(model, view);
    }
}
