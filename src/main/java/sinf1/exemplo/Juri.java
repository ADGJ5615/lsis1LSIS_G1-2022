package sinf1.exemplo;


public class Juri {
  private int id;
  private String nome;
  private String pass;


  public Juri(int id, String nome,String pass){
    this.id = id;
    this.nome=nome;
    this.pass=pass;

  }
  public Juri(){

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
    return "Juri numero: "+id+",nome: "+nome;
  }
}