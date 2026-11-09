package com.bits.leave;

import static org.junit.Assert.*;
import org.junit.Test;

public class LeaveCalculatorTest {

    private final LeaveCalculator calc = new LeaveCalculator();

    @Test
    public void testLeaveBalance() {
        assertEquals(15, calc.calculateBalance(24, 9));
    }

    @Test
    public void testLeaveEncashment() {
        assertEquals(15000.0, calc.calculateEncashment(10, 45000.0), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInputThrows() {
        calc.calculateBalance(-1, 5);
    }
}
