package sinf1.exemplo;

public class Competicao {
  private int id;
  private int id_robot;
  private int id_ronda;
  private int velocidade;
  private int tempo;

  public Competicao(int id, int id_robot, int int_ronda, int velocidade, int tempo){
    this.id=id;
    this.id_robot=id_robot;
    this.id_ronda=id_ronda;
    this.velocidade=velocidade;
    this.tempo=tempo;
  }

  public int getId() {
    return id;
  }

  public int getId_ronda() {
    return id_ronda;
  }

  public int getTempo() {
    return tempo;
  }

  public int getId_robot() {
    return id_robot;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setId_robot(int id_robot) {
    this.id_robot = id_robot;
  }

  public void setId_ronda(int id_ronda) {
    this.id_ronda = id_ronda;
  }

  public void setTempo(int tempo) {
    this.tempo = tempo;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

}
