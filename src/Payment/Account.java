package Payment;

import Person.Person;

import java.time.LocalDate;
import java.util.ArrayList;

public class Account {

	protected Person Inhaber;
	protected int Saldo;
	protected LocalDate Eroeffnungsdatum;
	protected ArrayList<Payment> Payment;


	public Account(Person pperson) {
		this.Inhaber=pperson;
		this.setEroeffnungsdatum();
		System.out.println("Account wurde erstellt.");
		Payment = new ArrayList<Payment>();
	}

	public Person getInhaber() {
		return this.Inhaber;
	}

	public void setInhaber(Person inhaber) {
		this.Inhaber = inhaber;
	}

	public double getSaldo() {
		return (double)this.Saldo/100;
	}

	public void setSaldo(double saldo) {
		this.Saldo = (int)Math.round(saldo*100);
	}

	public LocalDate getEroeffnungsdatum() {
		return this.Eroeffnungsdatum;
	}

	public void setEroeffnungsdatum(LocalDate eroeffnungsdatum) {
		this.Eroeffnungsdatum = eroeffnungsdatum;
	}

	public void setEroeffnungsdatum() {
		this.Eroeffnungsdatum = LocalDate.now();
	}



	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(';');
		builder.append(this.Inhaber);
		builder.append(';');
		builder.append(this.Saldo);
		builder.append(';');
		builder.append(this.Eroeffnungsdatum);
		return builder.toString();
	}

}
