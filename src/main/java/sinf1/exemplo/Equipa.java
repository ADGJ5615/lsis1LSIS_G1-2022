package sinf1.exemplo;

import java.util.Date;

public class Equipa {
  private int id;
  private String nome;
  private String pass;


  public Equipa(int id, String nome,String pass){
    this.id = id;
    this.nome=nome;
    this.pass=pass;

  }
  public Equipa(){

  }
  public int getId(){
    return id;
  }
  public String getNome(){
    return nome;
  }

  public String getPass() {
    return pass;
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }

  @Override
  public String toString() {
    return "Equipa numero: "+id+",nome: "+nome;
  }
}

