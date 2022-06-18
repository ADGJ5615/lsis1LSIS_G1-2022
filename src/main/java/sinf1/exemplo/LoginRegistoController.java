package sinf1.exemplo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
 public String reconhecerLogin(String Username, String Password) {
        if (LoginEquipa(Username, Password)) {
            return "equipa";
        } else if (LoginJuri(Username, Password)) {
            return "juri";
        }
        return null;
    }

    public boolean LoginEquipa(String Username, String Password) {
        String sql = "Select * from Equipa where nome = ? and password = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm;
        boolean res = false;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, Username);
            pstm.setString(2, Password);
            
            rs = pstm.executeQuery();
            if(rs.next()){
                String user = rs.getString("nome");
                String pass = rs.getString("password");
                res = true;
            } 
            pstm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
        public boolean LoginJuri(String Username, String Password) {
        String sql = "Select * from Elementos_juri where nome = ? and password = ?";
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm;
        boolean res = false;
        ResultSet rs = null;

        try {
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, Username);
            pstm.setString(2, Password);
            
            rs = pstm.executeQuery();
            if(rs.next()){
                String user = rs.getString("nome");
                String pass = rs.getString("password");
                res = true;
            } 
            pstm.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return res;
    }
}

