package sinf1.exemplo;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;
import static io.vertx.ext.web.handler.StaticHandler.DEFAULT_WEB_ROOT;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Misterio
 */
class Handlers {

    List<Aluno> BDfalsa = new ArrayList<>();
    String webRoot = DEFAULT_WEB_ROOT;

    Repository repo;
    public Handlers(Repository repo) {
        this.repo = repo;
    }

    //Nota: para alguns dos métodos foi necessário incluir a biblioteca Jackson no pom.xmml
    
    // responde ao pedido get
    public void sendStringJson(RoutingContext rc) {
        String jsonResult = "[ {\"nome\": \"1.Alberto\"}, "
                + "{\"nome\": \"2.Sampaio\"} ]";
        rc.response().headers().set("Content-Type", "application/json; charset=UTF-8");
        rc.response().end(jsonResult);
    }
    
    // responde ao pedido get - alternativa ao anterior
    public void sendArrayAsString(RoutingContext routingContext) {
        HttpServerResponse response = routingContext.response();
        response.putHeader("content-type", "text/plain; charset=utf-8");
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Alberto", "nome", 1));
        alunos.add(new Aluno("Sampaio", "apelido", 2));
        response.setStatusCode(200);
        response.end(alunos.toString());
     
    }


    public void criarAluno(RoutingContext rc) {
// Solucao1: requer a biblioteca Jackson - dependencias no pom.xml
        JsonObject body = rc.getBodyAsJson();
        String nome = body.getString("nome");
        String email = body.getString("email");
        String num =  body.getString("numero");
        Aluno aluno = new Aluno(nome, email, Integer.parseInt(num));

        // insere na BD falsa
        BDfalsa.add(aluno);
        System.out.println("aluno criado: " + aluno.toString());
        rc.response()
                .setStatusCode(201)
                .putHeader("content-type",
                        "application/json; charset=utf-8")
                .end(Json.encodePrettily(aluno));
    }

    public void actualizarAluno(RoutingContext rc) {
        //requer a biblioteca Jackson - dependencias no pom
        String numero = rc.request().getParam("numAluno");
        Aluno aluno = rc.getBodyAsJson().mapTo(Aluno.class);

        int indice = -1;
        for (int i = 0; i < BDfalsa.size(); i++) {
            if (BDfalsa.get(i).numero == Integer.parseInt(numero)) {
                indice = i;
            }
        }
        if (indice == -1) {
            System.out.println("inexistente");
        } else {
            BDfalsa.set(indice, aluno);
            System.out.println("aluno actualizado: " + aluno.toString());
        }

        rc.response()
                .setStatusCode(201)
                .putHeader("content-type",
                        "application/json; charset=utf-8")
                .end(Json.encodePrettily(aluno));
    }

    // ressponde a pedido get the uma página nova (estática)
    public void paginaNova(RoutingContext rc) {
        rc.response().setStatusCode(200)
                .putHeader("content-type", "text/html")
                .sendFile(webRoot + "/html/nova1.html");

    }
        // ressponde a pedido get the uma página nova (estática)
    public void paginaNova2(RoutingContext rc) {
        rc.response().setStatusCode(200)
                .putHeader("content-type", "text/html")
                .sendFile(webRoot + "/html/nova2.html");

    }

}
