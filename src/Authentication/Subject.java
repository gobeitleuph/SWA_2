package Authentication;


import Person.Person;

public class Subject {

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

}