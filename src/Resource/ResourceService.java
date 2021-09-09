package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class ResourceService {

	public Car m_Car;
	private Resource combination;
	public ResourceService(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getSelectedResource(String label, BigDecimal price,Boolean availability){
		Resource car = new Car();
		car.setLabel(label);
		car.setPrice(price);
		car.setAvailability(availability);

		combination = new ChildSeat("comfortplus",new BigDecimal("300"),true,car);
		System.out.println(combination.getLabel() + combination.getPrice()+ combination.getAvailability());
		return true;
	}


	public Resource getResource() {

		return combination;
	}


}//end ResourceService