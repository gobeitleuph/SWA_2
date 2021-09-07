package Resource;

import Person.Person;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class ResourceServiceTest {

    private ResourceService resourceService;

    @BeforeEach
    void setUp() {
        resourceService = new ResourceService();
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    @Order(1)
    void canResourceBeGotten(){
        Assertions.assertTrue(resourceService.getSelectedResource());
    }
}