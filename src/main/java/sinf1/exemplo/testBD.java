package sinf1.exemplo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import static sinf1.exemplo.DAL.inserirEquipa;
public class testBD {
  public static void main(String[] args) throws SQLException {
    Equipa equipateste = new Equipa(1,"Equipa1","abc",new Date("27/04/2022"));
    inserirEquipa(equipateste);

  }



}
