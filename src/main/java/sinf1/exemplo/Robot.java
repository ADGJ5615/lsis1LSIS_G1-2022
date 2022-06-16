package sinf1.exemplo;

public class Robot {
  private static int contadorId= 1;
  private int id ;
  private int id_equipa;
  private String mac_adress;


  public Robot(){

  }
  // INSERIR ROBOTS NA BD
  public Robot( int id_equipa,String mac_adress){

    this.id_equipa=id_equipa;
    this.mac_adress=mac_adress;
  }

  // PARA OBTER ROBOTS DA BD
public Robot(int id, int id_equipa, String mac_adress){
    this.id=id;
    this.id_equipa=id_equipa;
    this.mac_adress=mac_adress;

}
  public void setId(int id) {
    this.id = id;
  }

  public void setId_equipa(int id_equipa) {
    this.id_equipa = id_equipa;
  }

  public void setMac_adress(String mac_adress) {
    this.mac_adress = mac_adress;
  }

  public int getId() {
    return id;
  }

  public int getId_equipa() {
    return id_equipa;
  }

  public String getMac_adress() {
    return mac_adress;
  }

}
