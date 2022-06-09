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
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO Equipa (id,nome,password,_data_criacao_) VALUES (?,?,?,?)");
       stmt.setInt(1,equipa.getId());
       stmt.setString(2, equipa.getNome());
       stmt.setString(3,equipa.getPass());
       stmt.setDate(4, new java.sql.Date(equipa.getDataCriacao().getTime()));
       stmt.executeUpdate();
       conn.close();
     }catch(Exception e){
       System.out.println(e);
     }
  }

  public static void selecionarEquipa(int id){
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      stmt = conn.prepareStatement("SELECT * FROM Equipa WHERE id=?");
      stmt.setInt(1, id);
      rs = stmt.executeQuery();
      ResultSetMetaData rsMetaData = rs.getMetaData();
      int numberOfCols = rsMetaData.getColumnCount();
      while (rs.next()) {
        List<Object> values = new ArrayList<>();
        for (int i = 1; i <= numberOfCols; i++) {
          Object object = rs.getObject(i);
          values.add(object);
        }
        for (int i = 0; i < values.size(); i++) {
          System.out.println(values.get(i));
        }
      }
      conn.close();

    }catch (Exception e){
      System.out.println(e);


    }
  }

  public static Equipa obterEquipa(int id){
    Equipa result = null;
    try{
      Connection conn = DBConnection.getConnection();
      PreparedStatement stmt = null;
      ResultSet rs = null;
      stmt = conn.prepareStatement("SELECT * FROM Equipa WHERE id=?");
      stmt.setInt(1, id);
      rs = stmt.executeQuery();
      Equipa equipaRetornada = new Equipa();
      if (rs.next()) {
        equipaRetornada.setId(rs.getInt("id"));
        equipaRetornada.setNome(rs.getString("nome"));
        equipaRetornada.setPass(rs.getString("password"));
        equipaRetornada.setDataCriacao(rs.getDate("_data_criacao"));

      }
      conn.close();
      return equipaRetornada;


    }catch (Exception e){
    System.out.println(e);
    }
return new Equipa();
  }
  }




