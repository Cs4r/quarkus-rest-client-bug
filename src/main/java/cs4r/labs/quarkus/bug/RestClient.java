package cs4r.labs.quarkus.bug;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public interface RestClient {

    @POST
    @Consumes("application/vnd.kafka.json.v2+json")
    @Produces(MediaType.APPLICATION_JSON)
    void post(String body);
}
