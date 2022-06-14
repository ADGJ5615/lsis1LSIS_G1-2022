package sinf1.exemplo;

import io.vertx.core.*;
import io.vertx.core.datagram.DatagramSocket;
import io.vertx.core.datagram.DatagramSocketOptions;
import io.vertx.core.dns.DnsClient;
import io.vertx.core.dns.DnsClientOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.file.FileSystem;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.Json;
import io.vertx.core.net.NetClient;
import io.vertx.core.net.NetClientOptions;
import io.vertx.core.net.NetServer;
import io.vertx.core.net.NetServerOptions;
import io.vertx.core.shareddata.SharedData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Supplier;

import static sinf1.exemplo.DAL.inserirEquipa;
import static sinf1.exemplo.DAL.obterEquipa;

public class testBD {

  public static void main(String[] args) throws SQLException {
   //ArrayList<Equipa> equipasTeste = new ArrayList<>();
   //DAL dal = new DAL();
   //equipasTeste= dal.obterEquipasArray();
   //System.out.println(equipasTeste.get(2).getId());

Equipa equipa1 = new Equipa(1,"Equipa1","XD");
    Equipa equipa2 = new Equipa(2,"Equipa1","XD");

    Equipa equipa3 = new Equipa(3,"Equipa1","XD");

    Equipa equipa4 = new Equipa(4,"Equipa1","XD");

    inserirEquipa(equipa1);
    inserirEquipa(equipa2);inserirEquipa(equipa3);inserirEquipa(equipa4);




  }
}
