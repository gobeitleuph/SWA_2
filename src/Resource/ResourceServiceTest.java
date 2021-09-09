package Resource;

import org.junit.jupiter.api.*;
import java.math.BigDecimal;



class ResourceServiceTest {
    private String label;
    private BigDecimal price;
    private Boolean availability;
    private ResourceService resourceService;

    @BeforeEach
    void setUp() {
        resourceService = new ResourceService();
        label = "LabelTest";
        price = new BigDecimal("100");
        availability = true;
    }


    @AfterEach
    void tearDown() {
    }
    @Test
    @Order(1)
    void canResourceBeGotten(){
        Assertions.assertTrue(resourceService.getSelectedResource(label,price,availability));
    }
}