package Person;


import Authentication.CredentialType;

import java.time.LocalDate;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class LegalPerson extends Person {

	@Override
	public String getName() {
		return super.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getEmailAddress() {
		return super.emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public int getPhoneNumber() {
		return super.phoneNumber;
	}

	@Override
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public CredentialType getCredentialType() {
		return super.credentialType;
	}

	@Override
	public void setCredentialType(CredentialType credentialType) {
		this.credentialType = credentialType;
	}

	@Override
	public String getSurname() {
		return null;
	}

	@Override
	public void setSurname(String surname) {

	}

	@Override
	public LocalDate getBirthday() {
		return null;
	}

	@Override
	public void setBirthday(LocalDate birthday) {

	}

	@Override
	public String getCredentialIdentifier() {
		return super.credentialIdentifier;
	}

	@Override
	public void setCredentialIdentifier(String credentialIdentifier) {
		this.credentialIdentifier = credentialIdentifier;
	}

	@Override
	public boolean personCreated() {
		return true;
	}

	public LegalPerson(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
}//end LegalPerson