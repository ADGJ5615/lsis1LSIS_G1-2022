package sinf1.exemplo;

public class Ronda {
  private int id;
  private String tipo;
  private String nome;
  private int id_competicao;

  public Ronda(int id, String tipo, String nome, int id_competicao){
    this.id=id;
    this.tipo=tipo;
    this.nome=nome;
    this.id_competicao=id_competicao;

  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public void setId_competicao(int id_competicao) {
    this.id_competicao = id_competicao;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public int getId_competicao() {
    return id_competicao;
  }

  public String getNome() {
    return nome;
  }
  public String getTipo() {
    return tipo;
  }
}
