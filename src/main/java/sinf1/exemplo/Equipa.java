package sinf1.exemplo;

import java.util.Date;

public class Equipa {
  private int id;
  private String nome;
  private String pass;
  private Date dataCriacao;

  public Equipa(int id, String nome,String pass, Date dataCriacao){
    this.id = id;
    this.nome=nome;
    this.pass=pass;
    this.dataCriacao=dataCriacao;
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

  public Date getDataCriacao(){
    return dataCriacao;
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

  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

}
