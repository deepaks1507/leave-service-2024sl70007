package com.bits.leave;

  import com.sun.net.httpserver.HttpServer;
  import java.io.OutputStream;
  import java.net.InetSocketAddress;

  public class LeaveServiceApp {
      public static void main(String[] args) throws Exception {
          LeaveCalculator calc = new LeaveCalculator();
          int remaining = calc.calculateBalance(20, 8);
          double encashment = calc.calculateEncashment(remaining, 45000.0);
          String appEnv = System.getenv().getOrDefault("APP_ENV", "local");

          String response = "APP_ENV: " + appEnv + "\n"
                  + "Remaining Leave: " + remaining + " days\n"
                  + "Encashment Amount: " + encashment + "\n";

          HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
          server.createContext("/", exchange -> {
              exchange.sendResponseHeaders(200, response.length());
              OutputStream os = exchange.getResponseBody();
              os.write(response.getBytes());
              os.close();
          });
          server.start();
          System.out.println("APP_ENV: " + appEnv + " - Server started on port 8080");
      }
  }
