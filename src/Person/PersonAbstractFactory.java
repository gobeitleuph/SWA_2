package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public abstract class PersonAbstractFactory {
	public PersonAbstractFactory(){

	}


	public void finalize() throws Throwable {

	}
	public static PersonFactory createPersonFactory(PersonType personType){

		PersonFactory personFactory = null;


		switch (personType){
			case LegalPerson: {
				personFactory = new LegalPersonFactory();
			}
			case NaturalPerson: {
				personFactory = new NaturalPersonFactory();
			}

		}
		return personFactory;
	}
}//end PersonFactory