package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class ChildSeat extends Resource {

	private String label;
	private BigDecimal price;
	private Boolean availability;

	public ChildSeat(String label, BigDecimal price, Boolean availability, ICar car){
		super(car);
		this.label = label;
		this.price = price;
		this.availability = availability;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void setPrice(BigDecimal price) {

	}

	@Override
	public BigDecimal getPrice() {
		return null;
	}

	@Override
	public void setLabel(String label) {

	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public void setAvailability(Boolean availability) {

	}

	@Override
	public Boolean getAvailability() {
		return null;
	}
}//end ChildSeat