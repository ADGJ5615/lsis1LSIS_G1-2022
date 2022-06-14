package sinf1.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

  static final String URL = "jdbc:mysql://ctesp.dei.isep.ipp.pt:3306/2022sinf1_016";

  static final String USER = "2022sinf1_016";
  static final String PASS = "Qh48833hJE!";

  public static Connection getConnection() {
    try {
      DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
      Connection conn = DriverManager.getConnection(URL, USER, PASS);
      System.out.println("Connection to " + conn.getCatalog() + " succeded!");
      return conn;
    } catch (SQLException exc) {
      exc.printStackTrace();
      throw new RuntimeException("Error connecting!", exc);

    }
  }
}
