package org.example;

import junit.framework.TestCase;

public class HeadlessSimulatorTest extends TestCase {

    public void testAddition() {
        CalculatorModel model = new CalculatorModel();
        double a = 12;
        double b = 3;
        double res = model.calculate(a, b, "+");
        assertEquals(15.0, res);
    }

    public void testSubtraction() {
        CalculatorModel model = new CalculatorModel();
        double res = model.calculate(5, 8, "-");
        assertEquals(-3.0, res);
    }

    public void testMultiply() {
        CalculatorModel model = new CalculatorModel();
        double res = model.calculate(4, 2.5, "*");
        assertEquals(10.0, res);
    }

    public void testDivide() {
        CalculatorModel model = new CalculatorModel();
        double res = model.calculate(10, 2, "/");
        assertEquals(5.0, res);
    }

    public void testDivideByZeroThrows() {
        CalculatorModel model = new CalculatorModel();
        try {
            model.calculate(1, 0, "/");
            fail("Expected ArithmeticException for division by zero");
        } catch (ArithmeticException ex) {
            // expected
        }
    }
}
