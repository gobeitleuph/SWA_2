package Person;


import Authentication.CredentialType;
import Payment.Account;

import java.time.LocalDate;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public abstract class Person {

	protected String name;
	protected String emailAddress;
	protected int phoneNumber;
	protected CredentialType credentialType;
	protected String surname;
	protected LocalDate birthday;
	protected String credentialIdentifier;
	protected Account account;


	public abstract String getName();
	public abstract void setName(String name);
	public abstract String getEmailAddress();
	public abstract void setEmailAddress(String emailAddress);
	public abstract int getPhoneNumber();
	public abstract void setPhoneNumber(int phoneNumber);
	public abstract CredentialType getCredentialType();
	public abstract void setCredentialType(CredentialType credentialType);
	public abstract String getSurname();
	public abstract void setSurname(String surname);
	public abstract LocalDate getBirthday();
	public abstract void setBirthday(LocalDate birthday);
	public abstract String getCredentialIdentifier();
	public abstract void setCredentialIdentifier(String credentialIdentifier);
	public abstract Account getAccount();
	public abstract void setAccount(Account account);

	public abstract boolean personCreated();


	public Person(){

	}




	public void finalize() throws Throwable {

	}
}