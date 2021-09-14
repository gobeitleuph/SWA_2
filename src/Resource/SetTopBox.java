package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class SetTopBox extends Resource {

	private String label;
	private BigDecimal price;
	private Boolean availability;

	public SetTopBox(String label, BigDecimal price, Boolean availability, ResourceSelection resource){
		super(resource);
		this.label = label;
		this.price = price;
		this.availability = availability;
	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public BigDecimal getPrice() {
		return resource.getPrice().add(this.price) ;
	}

	@Override
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getLabel() {
		return resource.getLabel() + "+" + this.label;
	}

	@Override
	public void setAvailability(Boolean availability) {
		this.availability = availability;
	}

	@Override
	public Boolean getAvailability() {
		return resource.getAvailability() & this.availability;
	}
}//end SetTopBox