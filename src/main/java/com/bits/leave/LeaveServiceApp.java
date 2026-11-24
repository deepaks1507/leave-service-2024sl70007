package com.bits.leave;

  public class LeaveServiceApp {
      public static void main(String[] args) {
          LeaveCalculator calc = new LeaveCalculator();
          int remaining = calc.calculateBalance(20, 8);
          double encashment = calc.calculateEncashment(remaining, 45000.0);
          System.out.println("APP_ENV: " + System.getenv().getOrDefault("APP_ENV", "local"));
          System.out.println("Remaining Leave: " + remaining + " days");
          System.out.println("Encashment Amount: " + encashment);
      }
  }
