package Content;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContentServiceTest {

    private ContentService contentService;
    private Content content;
    @BeforeEach
    void setUp() {
        contentService = new ContentService();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canContentBeAdded(){
        Assertions.assertTrue(contentService.addContent(content));
    }
}