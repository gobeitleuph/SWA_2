package Authentication;


import Person.Person;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class FingerPrintStrategy implements Credential {

	public FingerPrintStrategy(){

	}

	public void finalize() throws Throwable {

	}

	@Override
	public void executeStrategy(Person person, String credentialIdentifierInput) {
		if (person.getCredentialIdentifier() == credentialIdentifierInput){
			System.out.printf("Authentication successfull");
		}
		else {
			System.out.println("Authentication fail");
		}
	}

}//end FingerPrintStrategy