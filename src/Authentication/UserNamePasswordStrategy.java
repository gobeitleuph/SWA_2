package Authentication;


import Person.Person;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class UserNamePasswordStrategy implements Credential {

	public UserNamePasswordStrategy(){

	}

	private boolean result;

	@Override
	public void executeStrategy(Person person, String credentialIdentifierInput) {
		if (person.getCredentialIdentifier() == credentialIdentifierInput){
			System.out.printf("Authentication successfull");
			this.result = true;
		}
		else {
			System.out.println("Authentication fail");
			this.result = false;
		}
	}

	public boolean getResult(){
		return result;
	}
}//end UserNamePasswordStrategy