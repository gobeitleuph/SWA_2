package Payment;

import Payment.Transaktion;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Account {

	protected String Accountnummer;
	protected String Inhaber;
	protected int Saldo;
	protected LocalDate Eroeffnungsdatum;
	protected ArrayList<Transaktion> Transaktionen;


	// Standardkonstruktor
	public Account() {
		this.setEroeffnungsdatum();
		this.setAccountnummer();
		System.out.println("Account ["+ getAccountnummer() +"] erstellt.");
		Transaktionen = new ArrayList<Transaktion>();
	}

	// Standardkonstruktor mit Variablen
	public Account(String pInhaber, double pSaldo) {
		this.setInhaber(pInhaber);
		this.setAccountnummer();
		this.setEroeffnungsdatum();
		// negativen Saldo dürfen wir nicht haben
		if(pSaldo < 0) {
			System.out.println("Negativer Saldo nicht möglich!");
			this.setSaldo(0);
		}
		else
			this.setSaldo(pSaldo);
		System.out.println("Account ["+ getAccountnummer() +"] mit Inhaber: " + getInhaber() + " erstellt.");
		System.out.println("Aktueller Accountstand: " + getSaldo() + "€");
		this.Transaktionen = new ArrayList<Transaktion>();
	}

	// Konstruktor zum auslesen aus der Datei
	public Account(String pAccountnummer, String pInhaber, double pSaldo, LocalDate pDatum) {
		this.Accountnummer = pAccountnummer;
		this.Inhaber = pInhaber;
		setSaldo(pSaldo);
		this.Eroeffnungsdatum = pDatum;
	}


	public String getAccountnummer() {
		return this.Accountnummer;
	}

	private void setAccountnummer() {
		this.Accountnummer = generateAccountnummer();
	}

	public String getInhaber() {
		return this.Inhaber;
	}

	public void setInhaber(String inhaber) {
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


	// Generiert eine neue 10 stellige AccountNr
	public static String generateAccountnummer() {

		String lResult = "";
		// 10 mal Zufallszahl
		for(int i=0; i<10; i++) {
			// Zufallszahl zwischen 0 & 9
			lResult += (int)(Math.random()*10);
		}
		return lResult;
	}

	// Gibt die Umsätze und den Accountstand als Accountauszug aus
	public void Accountauszug() {
		System.out.println("+-------------------------------------+");
		System.out.println("+	Accountnummer: " + this.getAccountnummer());
		System.out.println("+	Inhaber: " + this.getInhaber());
		System.out.println("+");
		System.out.println("+");
		// Durchlaufen wir alle Transaktionen
		for(int i = 0; i < this.Transaktionen.size(); i++){
			Transaktion lTrans = this.Transaktionen.get(i);
			System.out.println("+	Überweisung: " + lTrans.getDate());
			System.out.println("+	Empfänger  : " + lTrans.Receiver.getInhaber() + " [" + lTrans.Receiver.getAccountnummer() + "]");
			System.out.println("+	Betrag     : " + lTrans.getValue());
			System.out.println("+");
		}
		System.out.println("+	Accountstand: " + this.getSaldo());
		System.out.println("+-------------------------------------+");
	}

	// Unsere eigene Rundungsmethode auf 2 Nachkommastellen
	public int round(int pValue) {

		return Math.round(pValue);
	}

	// FÜhrt eine Überweisung durch
	public void ueberweisung(Account pReceiver, double pValue) {
		if(this.getSaldo() < 0)
			System.out.println("Transaktion kann nicht durchgeführt werden, da der Saldo zu gering ist.");

		Transaktion lTrans = new Transaktion(this, pReceiver, (int)Math.round(pValue*100));
		this.Transaktionen.add(lTrans);
		lTrans.Commit();
	}

	// Dient zum speichern des Objekts
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(this.Accountnummer);
		builder.append(';');
		builder.append(this.Inhaber);
		builder.append(';');
		builder.append(this.Saldo);
		builder.append(';');
		builder.append(this.Eroeffnungsdatum);
		return builder.toString();
	}

}
