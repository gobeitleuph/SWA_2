package ViewController;

import Authentication.CredentialType;
import Person.Person;
import Person.PersonService;
import Person.PersonType;

import java.time.LocalDate;

public class PersonController implements CommandController{
    protected PersonType personType;
    protected String name;
    protected String emailAddress;
    protected int phoneNumber;
    protected CredentialType credentialType;
    protected String surname;
    protected LocalDate birthday;
    protected String credentialIdentifier;
    protected Person person;

    public PersonController(PersonType personType, String name, String emailAddress, int phoneNumber, CredentialType credentialType, String surname, LocalDate birthday, String credentialIdentifier) {
        this.personType = personType;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.credentialType = credentialType;
        this.surname = surname;
        this.birthday = birthday;
        this.credentialIdentifier = credentialIdentifier;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case "createPerson":{
                PersonService personService = new PersonService();
                personService.createPerson(personType, name, emailAddress, phoneNumber, credentialType, surname, birthday, credentialIdentifier);
                this.person = personService.getPerson();
                break;
            }

        }


    }
    public Person getPerson(){
        return person;
    }
}
