package ViewController;

import Authentication.AuthenticationService;
import Person.Person;

public class AuthenticationController implements CommandController {
    private Person person;
    private String credentialIdentifierInput;
    private boolean authentication;

    public AuthenticationController(Person person, String credentialIdentifierInput) {
        this.person = person;
        this.credentialIdentifierInput = credentialIdentifierInput;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case"authenticatePerson":
                AuthenticationService authenticationService = new AuthenticationService();
                authenticationService.authenticateSubject(person, credentialIdentifierInput);
                this.authentication = authenticationService.getAuthentication();
                break;
        }


    }
    public boolean getAuthentication(){
        return authentication;
    }
}
