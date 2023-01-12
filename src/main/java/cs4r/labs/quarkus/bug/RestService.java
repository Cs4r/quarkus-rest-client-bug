package cs4r.labs.quarkus.bug;

import io.quarkus.runtime.Startup;
import lombok.SneakyThrows;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URL;


@Startup
public class RestService {

    private RestClient restClient;

    @SneakyThrows
    public RestService(@ConfigProperty(name = "endpoint.url") String endpointUrl) {
            restClient = RestClientBuilder.newBuilder()
                    .baseUrl(new URL(endpointUrl))
                    .build(RestClient.class);
    }


    @SneakyThrows
    public void send(String message) {
        String body = String.format("{\"records\":[{\"value\":%s}]}", message);
        restClient.post(body);
    }
}
