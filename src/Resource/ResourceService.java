package Resource;


import java.math.BigDecimal;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class ResourceService {

	private ResourceSelection combination;
	public ResourceService(){

	}

	public void finalize() throws Throwable {

	}
	public boolean getSelectedResource(String label, BigDecimal price,Boolean availability, ResourceSelection car){
		combination = new ChildSeat(label,price,availability,car);
		//System.out.println(combination.getLabel() + combination.getPrice()+ combination.getAvailability());
		return true;
	}


	public ResourceSelection getResource() {
		return combination;
	}


}//end ResourceService