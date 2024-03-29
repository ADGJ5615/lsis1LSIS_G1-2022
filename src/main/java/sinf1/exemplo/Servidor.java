package sinf1.exemplo;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.file.FileSystemOptions;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.StaticHandler;

import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import static sinf1.exemplo.DAL.inserirEquipa;
import static sinf1.exemplo.DAL.obterEquipa;

import static sinf1.exemplo.DAL.inserirJuri;


/**
 *
 * @author airton
 */
public class Servidor extends AbstractVerticle {

  private String webRoot = DEFAULT_WEB_ROOT;

  @Override
  public void start(Promise<Void> promise) throws Exception {
    Router router = Router.router(vertx);



    // por pré-definição serve index.html
    router.route().handler(BodyHandler.create());
    router.route(HttpMethod.GET, "/*").handler(StaticHandler.create(webRoot));
    router.route(HttpMethod.GET,"/obterEquipas").handler(this::sendArrayAsStringEquipas);
    router.post("/Equipa/registarEquipa").handler(this::registarEquipa);
    router.post("/Juri/registarJuri").handler(this::registarJuri);
    router.post("/Robot/registarRobot").handler(this::registarRobot);
    router.post("/Competicao/registarCompeticao").handler(this::registarCompeticao);
    router.post("/Login").handler(this::login);


    // cria servidor HTTP
    HttpServerOptions options = new HttpServerOptions();
    options.setPort(8013);

    vertx.createHttpServer(options)
      .requestHandler(router)
      .listen(res -> {
        if (res.succeeded()) {
          promise.complete();
          System.out.println("Servidor HTTP no porto " + options.getPort());
        } else {
          promise.fail(res.cause());
          System.out.println("Nao foi possivel iniciar o servidor HTTP");
        }
      });

  }



  // ----------------EQUIPAS--------------------------------

  private void registarEquipa(RoutingContext rc) {
    String nome = rc.request().getParam("nome");
    String password = rc.request().getParam("pass");
    int id = Integer.parseInt(rc.request().getParam("id"));
    try {
      HttpServerResponse response = rc.response();
      response.putHeader("content-type", "application/json; charset=utf-8");
      response.setStatusCode(200);
      LoginRegistoController loginregisto = new LoginRegistoController();
      response.end(Json.encodePrettily(loginregisto.registarEquipa(id, nome, password)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
   private void registarRobot(RoutingContext rc){
    int idEquipa= Integer.parseInt(rc.request().getParam("idEquipaRobot"));
    String mac_adress= rc.request().getParam("mac_adress");
    try{
      HttpServerResponse response = rc.response();
      response.putHeader("content-type", "application/json; charset=utf-8");
      response.setStatusCode(200);
      DAL dal = new DAL();
      response.end(Json.encodePrettily(dal.registarRobot(idEquipa,mac_adress)));
    }catch (Exception e){
      e.printStackTrace();
    }
  }
 private void registarJuri (RoutingContext rc){
   String nome = rc.request().getParam("nome");
   String password = rc.request().getParam("pass");
   int id = Integer.parseInt(rc.request().getParam("id"));
   try {
            HttpServerResponse response = rc.response();
            response.putHeader("content-type", "application/json; charset=utf-8");
            response.setStatusCode(200);
            LoginRegistoController loginregisto = new LoginRegistoController();
            response.end(Json.encodePrettily(loginregisto.registarJuri(id, nome, password)));
        } catch (Exception e) {
            e.printStackTrace();
        }
  }
 private void registarCompeticao(RoutingContext rc){
    int id = Integer.parseInt(rc.request().getParam("id"));
    String nome = rc.request().getParam("nomeCompeticao");
    Date dataUtil = new Date(rc.request().getParam("dataC")); //year/month/date
    java.sql.Date dataSQL= new java.sql.Date(dataUtil.getTime());
    try{
      HttpServerResponse response = rc.response();
      response.putHeader("content-type", "application/json; charset=utf-8");
      response.setStatusCode(200);
      DAL dal = new DAL();
      //response.end(Json.encodePrettily(dal.registarRobot(idEquipa,mac_adress)));
      response.end(Json.encodePrettily(dal.registarCompeticao(id,nome,dataSQL)));
    }catch (Exception e){
      e.printStackTrace();
    }

}

 public void selecionarEquipa(RoutingContext rc){
    String id = rc.request().getParam("id");
    int idFinal = Integer.parseInt(id);
    Equipa equipa = obterEquipa(idFinal);
    HttpServerResponse response = rc.response();
    response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8");
    response.end(Json.encodePrettily(equipa));
}
// GET Equipas
  public void sendArrayAsStringEquipas(RoutingContext routingContext) {
    HttpServerResponse response = routingContext.response();
    response.putHeader("content-type", "text/plain; charset=utf-8");
    List<Equipa> equipas = new ArrayList<>();
    DAL dal = new DAL();
    equipas = dal.obterEquipasArray();
    response.end(Json.encodePrettily(equipas));
    //response.end(equipas.toString());
    response.setStatusCode(200);
  }

  @Override
  public void stop() {
    System.out.println("---> LSIS stop! ");
  }

  public static void main(String[] args) {
    FileSystemOptions fsOptions = new FileSystemOptions();
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new Servidor());
  }
  
  public void login(RoutingContext rc) {
        String Username = rc.request().getParam("nome");
        String Password = rc.request().getParam("pass");

        LoginRegistoController log = new LoginRegistoController();
        
        String cargo = log.reconhecerLogin(Username, Password);

        HttpServerResponse response = rc.response();
        if (cargo != null) {
            response.putHeader("content-type", "application/json; charset=utf-8");
            if (cargo == "equipa") {
                response.setStatusCode(200);
            }
            if (cargo == "juri") {
                response.setStatusCode(201);
            }
            response.end();
        }
    }
}
