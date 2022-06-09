package sinf1.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import static sinf1.exemplo.DAL.inserirEquipa;
public class testBD {
  static final String URL = "jdbc:mysql://localhost:3306/2022sinf1_002";

  static final String USER = "2022sinf1_002";
  static final String PASS = "Cv47296uLS#";


  public static void main(String[] args) throws SQLException {
  //  Equipa equipa = new Equipa(1,"joao","abc",new Date("27/04/2022"));
   // DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
    //Connection conn = DriverManager.getConnection(URL, USER, PASS);
   //  System.out.println("Connection to " + conn.getCatalog() + " succeded!");
  }



}
