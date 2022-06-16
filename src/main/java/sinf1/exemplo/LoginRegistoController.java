package sinf1.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoginRegistoController {

    public LoginRegistoController() {
    }

public int registarEquipa(int id,String nome, String password) throws SQLException {
    Equipa equipa = new Equipa();
    equipa.setNome(nome);
    equipa.setPass(password);
    String SQL = "insert into Equipa (id,nome,password) values(?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps;
    int resultado = 0;
    try{
        ps = conn.prepareStatement(SQL);
        ps.setInt(1,id);
        ps.setString(2, nome);
        ps.setString(3, password);
        resultado = ps.executeUpdate();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    conn.close();
    return resultado;
}    
public int registarJuri(int id, String nome, String password) throws SQLException {
    Juri juri = new Juri();
    juri.setNome(nome);
    juri.setPass(password);
    String SQL = "insert into Elementos_juri (id,nome,password) values(?,?,?)";
    Connection conn = DBConnection.getConnection();
    PreparedStatement ps;
    int resultado = 0;
    try{
        ps = conn.prepareStatement(SQL);
        ps.setInt(1, id);
        ps.setString(2, nome);
        ps.setString(3, password);
        resultado = ps.executeUpdate();
    }
    catch(Exception e){
        e.printStackTrace();
    }
    conn.close();
    return resultado;
}
}
