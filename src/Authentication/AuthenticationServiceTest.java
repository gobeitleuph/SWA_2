package Authentication;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceTest {
    private AuthenticationService authenticationService;
    private Subject subject;
    private Credential credential;

    @BeforeEach
    void setUp() throws Exception{
        authenticationService = new AuthenticationService();
        subject = new Subject();
        credential = new Credential();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canPersonBeAuthenticated(){
        Assertions.assertTrue(authenticationService.authenticateSubject(subject, credential));
    }
}