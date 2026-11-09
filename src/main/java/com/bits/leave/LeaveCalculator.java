package com.bits.leave;

public class LeaveCalculator {

    // Remaining leave = entitlement - leaves taken (never below zero)
    public int calculateBalance(int entitlement, int leavesTaken) {
        if (entitlement < 0 || leavesTaken < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return Math.max(0, entitlement - leavesTaken);
    }

    // Encashment = balance days * (monthly salary / 30)
    public double calculateEncashment(int balanceDays, double monthlySalary) {
        if (balanceDays < 0 || monthlySalary < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        }
        return balanceDays * (monthlySalary / 30.0);
    }
}
