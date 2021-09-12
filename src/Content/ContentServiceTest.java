package Content;

import jdk.jshell.spi.SPIResolutionException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ContentServiceTest {

    private ContentService contentService;
    private Content content;
    private Folder folder;
    private String name;
    private Booking booking;

    @BeforeEach
    void setUp() {
        contentService = new ContentService();
        content = new File("TestFile");
        content.setBooking();
        name = "TestFolder";
        folder = new Folder(name);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @Order(1)
    void canContentBeAdded(){
        Assertions.assertTrue(contentService.addContent(content ,folder));
    }
}