package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class NaturalPerson extends Person {

	public NaturalPerson(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end NaturalPerson