package Authentication;


import Person.Person;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public interface Credential {
    void executeStrategy(Person person, String credentialIdentifierInput);
}