package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class PersonService {
	public PersonTyp personTyp;
	public PersonFactory m_PersonFactory;

	public PersonService(){

	}

	public void finalize() throws Throwable {

	}
	public boolean createPerson(PersonTyp personTyp){

		PersonFactory.createPerson(this.personTyp);
		return false;
	}
}//end PersonService