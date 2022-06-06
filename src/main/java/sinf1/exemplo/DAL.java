package sinf1.exemplo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import io.vertx.core.json.Json;


public class DAL {

  public static void inserirEquipa (Equipa equipa){
     try{
       Connection conn= DBConnection.getConnection(); //ver se faz conexao XD
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO Equipa (id,nome,data_criacao) VALUES (?,?,?)");
       stmt.setInt(1,equipa.getId());
       stmt.setString(2, equipa.getNome());
       stmt.setDate(3, new java.sql.Date(equipa.getDataCriacao().getTime()));
       stmt.executeUpdate();
       conn.close();
     }catch(Exception e){
       System.out.println(e);
     }
  }



}
