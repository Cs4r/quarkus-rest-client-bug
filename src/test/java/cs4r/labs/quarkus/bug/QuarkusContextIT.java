package cs4r.labs.quarkus.bug;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

@QuarkusTest
public class QuarkusContextIT {

    @Inject
    private RestService restService;

    @Test
    void testSend() {
        restService.send("{\"status\": \"ok\" }");
    }
}
