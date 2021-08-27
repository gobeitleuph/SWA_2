package Resource;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class Resource extends Car {

	public ICar m_ICar;
	public Car m_Car;

	public Resource(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end Resource