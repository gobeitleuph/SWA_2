package Person;


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
	public boolean addPerson(PersonType personType){

		personFactory = PersonAbstractFactory.createPersonFactory(personType);
		person = personFactory.createPerson();
		return false;
	}
}//end PersonService