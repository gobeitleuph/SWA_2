package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class NaturalPersonFactory implements PersonFactory{

	public NaturalPersonFactory(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	@Override
	public Person createPerson(){

		return new NaturalPerson();
	}
}//end NaturalPersonFactory