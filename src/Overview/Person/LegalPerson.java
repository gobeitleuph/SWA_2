package Overview.Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class LegalPerson extends Person {

	public LegalPerson(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end LegalPerson