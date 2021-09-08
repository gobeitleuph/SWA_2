package Person;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public abstract class PersonFactory {
	public PersonFactory(){

	}


	public void finalize() throws Throwable {

	}
	public void createPerson(PersonTyp personTyp){

		switch (personType){
			case LegalPerson{
				return new LegalPerson();
			}
			case NaturalPerson{
				return new NaturalPerson();
			}
		}
	}
}//end PersonFactory