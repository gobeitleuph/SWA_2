package Authentication;


import Person.Person;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class AuthenticationService {

	public AuthenticationService(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param person
	 * @param //credential
	 */
	public boolean authenticateSubject(Person person){
		CredentialType credentialType = person.getCredentialType();
		Credential credentialStrategy;
		switch (credentialType){
			case UserNamePasswordStrategy: {
				credentialStrategy = new UserNamePasswordStrategy();
			}
			case FingerPrintStrategy: {
				credentialStrategy = new FingerPrintStrategy();
			}
			case EyeScanStrategy: {
				credentialStrategy = new EyeScanStrategy();
			}

			break;
			default:
				throw new IllegalStateException("Credential not known" + credentialType);
		}

		Subject subject = new Subject(credentialStrategy, person);
		subject.execute();
		System.out.println();

		return true;
	}
}//end AuthenticationService