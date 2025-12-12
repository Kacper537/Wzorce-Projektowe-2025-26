package org.example;

public class CalculatorModel {
    private double firstNumber = 0;
    private String operator = "";
    private boolean startNewNumber = false;

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public boolean isStartNewNumber() {
        return startNewNumber;
    }

    public void setStartNewNumber(boolean startNewNumber) {
        this.startNewNumber = startNewNumber;
    }

    public double calculate(double firstNumber, double secondNumber, String operator) {
        double result = 0;
        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/":
                if (secondNumber == 0) throw new ArithmeticException("Dzielenie przez zero");
                result = firstNumber / secondNumber;
                break;
        }
        return result;
    }
}
