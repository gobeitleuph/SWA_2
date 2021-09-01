package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class LegalPersonFactory implements PersonFactory{

	public LegalPersonFactory(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public Person createPerson(){
		return new LegalPerson();
	}
}//end LegalPersonFactory