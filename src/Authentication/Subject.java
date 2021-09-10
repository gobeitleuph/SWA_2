package Authentication;


import Person.Person;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class Subject {

	//public AuthenticationService m_AuthenticationService;

	private Credential credential;
	private Person person;
	private String credentialIdentifierInput;

	public Subject(Credential credential, Person person, String credentialIdentifierInput){
		this.credential = credential;
		this.person = person;
		this.credentialIdentifierInput = credentialIdentifierInput;
	}

	public void execute(){
		credential.executeStrategy(person, credentialIdentifierInput);
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}

//	public Person getPerson() {
//		return person;
//	}
//
//	public void setPerson(Person person) {
//		this.person = person;
//	}

	public void finalize() throws Throwable {

	}
}//end Subject