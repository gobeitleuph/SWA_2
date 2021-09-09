package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class Car implements Resource {

	private String label;
	private BigDecimal price;
	private Boolean availability;
	public Car(){

	}

	public void finalize() throws Throwable {

	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public BigDecimal getPrice() {
		return price;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Override
	public Boolean getAvailability() {
		return availability;
	}
}//end Car