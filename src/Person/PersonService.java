package Person;


import Authentication.CredentialType;

import java.time.LocalDate;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class PersonService {

	private PersonFactory personFactory;
	private Person person;
	public PersonService(){

	}

	public void finalize() throws Throwable {

	}
	public boolean createPerson(PersonType personType, String name, String emailAddress, int phoneNumber, CredentialType credentialType, String surname, LocalDate birthday){

		personFactory = PersonAbstractFactory.createPersonFactory(personType);
		person = personFactory.createPerson();


		person.setName(name);
		person.setEmailAddress(emailAddress);
		person.setPhoneNumber(phoneNumber);
		person.setCredentialType(credentialType);
		if (personType == PersonType.NaturalPerson){
			person.setBirthday(birthday);
			person.setSurname(surname);
		}

		if (person.personCreated()){
			System.out.println("Person erstellt");
			System.out.println(person.emailAddress + person.name + person.phoneNumber + person.credentialType + person.surname + person.birthday + personType);

			return true;
		}
		else{
			return false;
		}


	}
}