package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public interface Resource {
    void setPrice(BigDecimal price);
    BigDecimal getPrice();
    void setLabel(String label);
    String getLabel();
    void setAvailability(Boolean availability);
    Boolean getAvailability();
}