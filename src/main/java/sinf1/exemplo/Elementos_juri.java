package sinf1.exemplo;

public class Elementos_juri {
  private int id = 0;

  private String nome;

  public Elementos_juri(String nome){
    this.id=id++;
    this.nome=nome;
  }

  public void setId(int id) {
    this.id = id;

  }

  public int getId() {
    return id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}
