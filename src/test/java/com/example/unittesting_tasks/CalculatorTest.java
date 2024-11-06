package com.example.unittesting_tasks;

import com.example.unittesting_tasks.calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-2, 1));
        assertEquals(0, calculator.add(0, 0));
    }

    @Test
    void testSubstract() {
        assertEquals(5, calculator.substract(10, 5));
        assertEquals(-1, calculator.substract(-1, 0));
        assertEquals(0, calculator.substract(10, 10));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(16, calculator.multiply(4, 4));
        assertEquals(12, calculator.multiply(3, 4));
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3));
        assertThrows(ArithmeticException.class, () -> calculator.divide(1,0));
    }
}
