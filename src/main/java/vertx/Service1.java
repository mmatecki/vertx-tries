package vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.client.WebClient;

public class Service1 extends AbstractVerticle {

    @Override
    public void start() throws Exception {
        Router router = Router.router(vertx);

        router.post("/").handler(routingContext -> {
            WebClient webClient = WebClient.create(vertx);
            webClient.postAbs("http://localhost:10001/")
                    .sendStream(routingContext.request(), ar -> System.out.println("R: "+ar.result()));
        });

        vertx.createHttpServer()
                .requestHandler(router::accept)
                .listen(10000);
    }
}
