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

	private Credential credentialStrategy;

	public boolean authenticateSubject(Person person, String credentialIdentifierInput){
		CredentialType credentialType = person.getCredentialType();

		switch (credentialType){
			case UserNamePasswordStrategy: {
				credentialStrategy = new UserNamePasswordStrategy();
				break;
			}
			case FingerPrintStrategy: {
				credentialStrategy = new FingerPrintStrategy();
				break;
			}
			case EyeScanStrategy: {
				credentialStrategy = new EyeScanStrategy();
				break;
			}

			default:
				throw new IllegalStateException("Credential not known" + credentialType);
		}

		Subject subject = new Subject(credentialStrategy, person, credentialIdentifierInput);
		subject.execute();

		if(credentialStrategy.getResult()){
			return true;
		}else {
			return false;
		}

	}
	public boolean getAuthentication(){
		return credentialStrategy.getResult();
	}
}//end AuthenticationService