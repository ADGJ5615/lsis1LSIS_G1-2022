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
import java.util.RandomAccess;

import io.vertx.core.json.Json;
import io.vertx.ext.web.RoutingContext;


public class DAL {
  public DAL(){}

  public static void inserirEquipa (Equipa equipa){
     try{
       Connection conn= DBConnection.getConnection();
       PreparedStatement stmt = conn.prepareStatement("INSERT INTO Equipa (id,nome,password) VALUES (?,?,?)");
       stmt.setInt(1,equipa.getId());
       stmt.setString(2, equipa.getNome());
       stmt.setString(3,equipa.getPass());
      // stmt.setDate(4, new java.sql.Date(equipa.getDataCriacao().getTime()));
       stmt.executeUpdate();
       conn.close();
     }catch(Exception e){
       System.out.println(e);
     }
  }
  public static void inserirJuri(Elementos_juri juri){
    try {
      Connection conn = DBConnection.getConnection();
      PreparedStatement stmt = conn.prepareStatement("INSERT INTO Elementos_juri (id,nome) VALUES (?,?)");
      stmt.setInt(1,juri.getId());
      stmt.setString(2, juri.getNome());
      stmt.executeUpdate();
      conn.close();
    }catch (Exception e){
      System.out.println(e);
    }
  }
  public static void inserirRobot (Robot robot){
    Connection conn = DBConnection.getConnection();
    try {
      PreparedStatement stmt = conn.prepareStatement("INSERT INTO `Robot` (`id`, `id_equipa`, `mac_adress`) VALUES (?, ?, ?)");
      stmt.setInt(1,robot.getId());
      stmt.setInt(2, robot.getId_equipa());
      stmt.setString(3, robot.getMac_adress());
      stmt.executeUpdate();
      conn.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public int registarRobot(int idEquipa, String mac_adress) throws SQLException{
    String sql = "INSERT INTO Robot(id,id_equipa,mac_adress) VALUES (?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps;

    int resultado = 0;
    try{
      ps = conn.prepareStatement(sql);
      ps.setInt(1,0);
      ps.setInt(2,idEquipa );
      ps.setString(3, mac_adress);
      resultado = ps.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    conn.close();
    return resultado;

  }

  private int associarEquipaACompeticao(int idEquipa,int id_competicao) throws SQLException{
    String sql = "INSERT INTO associar_equipa(id,id_competicao,id_equipa) VALUES (?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps;
    int resultado = 0;
    try{
      ps = conn.prepareStatement(sql);
      ps.setInt(1,0);
      ps.setInt(2,id_competicao );
      ps.setInt(3, idEquipa);
      resultado = ps.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    conn.close();
    return resultado;
  }

  private int novaRonda(String tipo, String nome, int idCompeticao) throws SQLException{

    String sql = "INSERT INTO Ronda(id,tipo,nome,id_competicao) VALUES (?,?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps;

    int resultado = 0;
    try{
      ps = conn.prepareStatement(sql);
      ps.setInt(1,0);
      ps.setString(2,tipo);
      ps.setString(3, nome);
      ps.setInt(4,idCompeticao);
      resultado = ps.executeUpdate();
    }
    catch(Exception e){
      e.printStackTrace();
    }
    conn.close();
    return resultado;

  }
  public ArrayList<Robot> obterRobotsArray(){
    ArrayList<Robot> robots = new ArrayList<>();
    try{
      Connection conn = DBConnection.getConnection();
      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM Robot_";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        Robot robot = new Robot(rs.getInt("id"),rs.getInt("id_equipa"),rs.getString("mac_adress"));
        robots.add(robot);
      }
return robots;
    }catch (Exception e){
      e.printStackTrace();
    }
return robots;
  }


  public static void selecionarEquipa(int id) {
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

    } catch (Exception e) {
      System.out.println(e);


    }}


    public static Equipa obterEquipa ( int id){
      Equipa result = null;
      try {
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
         // equipaRetornada.setDataCriacao(rs.getDate("_data_criacao"));

        }
        conn.close();
        return equipaRetornada;


      } catch (Exception e) {
        System.out.println(e);
      }
      return new Equipa();
    }

  public ArrayList<Equipa> obterEquipasArray() {
    ArrayList<Equipa> equipas = new ArrayList<>();
    try {
      Connection conn = DBConnection.getConnection();
      Statement stmt = conn.createStatement();
      String sql = "SELECT * FROM Equipa";
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        Equipa equipa = new Equipa(rs.getInt("id"), rs.getString("nome"), rs.getString("password"));
        equipas.add(equipa);
      }
      conn.close();
      return equipas;
    }
    catch (Exception e){
      System.out.println(e);
    }
    return equipas;

  }







  }
