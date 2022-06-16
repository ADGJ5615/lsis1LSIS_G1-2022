package sinf1.exemplo;

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
import static sinf1.exemplo.DAL.inserirRobot;
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
    router.route(HttpMethod.POST, "/registarEquipa").handler(this::registarEquipa);
    router.route(HttpMethod.POST, "/registarJuri").handler(this::registarJuri);
    router.route(HttpMethod.GET,"/obterEquipas").handler(this::sendArrayAsStringEquipas);

    // router.route(HttpMethod.POST, "/registarCliente").handler(this::registarCliente);
    // router.route(HttpMethod.POST, "/updateCliente").handler(this::updateCliente);
    // router.route(HttpMethod.GET, "/selecionarCliente").handler(this::selecionarCliente);

//        router.route(HttpMethod.POST, "/alunos").handler(this::addAluno);
//       router.route(HttpMethod.GET,"/buscaAlunos").handler(this::sendArrayAsString);

    // cria servidor HTTP
    HttpServerOptions options = new HttpServerOptions();
    options.setPort(8000);

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


  //    }
//    public void sendArrayAsString(RoutingContext routingContext) {
//        HttpServerResponse response = routingContext.response();
//        response.putHeader("content-type", "text/plain; charset=utf-8");
//        List<Aluno> listaAlunos = new ArrayList<>();
//        selectAlunos(listaAlunos);
//        System.out.println(listaAlunos);
//        response.setStatusCode(200);
//        response.end(listaAlunos.toString());
//    }

  // ----------------EQUIPAS--------------------------------

  private void registarEquipa(RoutingContext rc)  {
    try {
      JsonObject body = rc.getBodyAsJson();
      //String idString = rc.request().getParam("idEquipa");
      String idString= body.getString("idEquipa");
      int id = Integer.parseInt(idString);
      //String nome = rc.request().getParam("nome");
      String nome = body.getString("nome");
     // String pass = rc.request().getParam("passEquipa");
      String pass = body.getString("passEquipa");
     // String dataCriacao = rc.request().getParam("dataCriacao");
      //Date dataCr = new SimpleDateFormat("dd/MM/yyyy").parse(dataCriacao);
      Equipa equipa = new Equipa(id, nome, pass);

      inserirEquipa(equipa);
      HttpServerResponse response = rc.response();
      response.setStatusCode(201).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
      response.end(Json.encodePrettily(equipa));
    } catch(Exception e){
      e.printStackTrace();
       }
    }
 private void registarJuri (RoutingContext rc){
    String nome = rc.request().getParam("nomeJuri");
    Elementos_juri juri = new Elementos_juri(nome);
    inserirJuri(juri);
    HttpServerResponse response = rc.response();
   response.setStatusCode(200).putHeader("content-type", "text/plain; charset=utf-8").end("ok");
   response.end(Json.encodePrettily(juri));
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
}
