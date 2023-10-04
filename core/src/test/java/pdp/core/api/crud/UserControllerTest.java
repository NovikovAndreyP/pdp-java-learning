package pdp.core.api.crud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pdp.core.models.entities.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port;
    private final TestRestTemplate restTemplate;

    @Autowired
    private UserControllerTest(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Test
    void createUser() {
        User user = new User();
        user.setEmail("test@test.test");
        user.setName("TestName");
        user.setPassword("password");
        ResponseEntity<User> res = this.restTemplate.postForEntity("http://localhost:" + port + "/user", user, User.class);
        assertEquals(HttpStatus.OK, res.getStatusCode());
    }

    @Test
    void getUsers() {
        ResponseEntity<User[]> responseBody = this.restTemplate.getForEntity("http://localhost:" + port + "/user", User[].class);
        assertEquals(HttpStatus.OK, responseBody.getStatusCode());
    }
}
