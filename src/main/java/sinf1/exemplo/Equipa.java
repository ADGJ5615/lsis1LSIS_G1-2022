package sinf1.exemplo;

import java.util.Date;

public class Equipa {
  private int id;
  private String nome;
  private Date dataCriacao;

  public Equipa(int id, String nome, Date dataCriacao){
    this.id = id;
    this.nome=nome;
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
  public Date getDataCriacao(){
    return dataCriacao;
}

  public void setId(int id) {
    this.id = id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setDataCriacao(Date dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

}
