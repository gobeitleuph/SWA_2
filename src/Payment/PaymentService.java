package Payment;


import Person.Person;

import java.util.ArrayList;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class PaymentService {


	private static ArrayList<Account> Account = new ArrayList<Account>();

	private static final String FILE_NAME = "Konten.csv";


	public PaymentService(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
//	public void payWithPaypal(Person pSenderperson, Person pReceiver){
//
//		Payment payment = new PayPalPayment(pSenderperson.getAccount(), pReceiver.getAccount())
//
//
//
//			}
//			auth.authenticateSubject(Sender.getInhaber(), pcredent);

	private	Person pReceiver;
	private	Person pSender;
	private Payment payment;

	public void payWithPaypalDE(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new PayPalPaymentDE(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());

	}
	public void payWithPaypalEN(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new PayPalPaymentEN(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());

	}

	public void payWithGoogleDE(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new GoogleWalletPaymentDE(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}

	public void payWithGoogleEN(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new GoogleWalletPaymentEN(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}

	public void payWithMobileDE(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new PayPalPaymentDE(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}

	public void payWithMobileEN(Person pSenderperson, Person pReceiver, int pvalue){
		this.payment = new PayPalPaymentEN(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		//payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}



//	public boolean payAmount(PaymentType ptype,Person pSenderperson, Person pReceiver, int pvalue){
//		this.pSender = pSenderperson;
//		this.pReceiver = pReceiver;


	public boolean payAmount(PaymentType ptype,Person pSenderperson, Person pReceiver, int pvalue){

		switch (ptype){

			case PayPalDE :{
				payWithPaypalDE(pSenderperson, pReceiver, pvalue);
				break;
			}
			case PayPalEN :{
				payWithPaypalEN(pSenderperson, pReceiver, pvalue);
				break;
			}


			case GoogleWalletDE:{
				payWithGoogleDE(pSenderperson, pReceiver, pvalue);
				break;
			}

			case GoogleWalletEN:{
				payWithGoogleEN(pSenderperson, pReceiver, pvalue);
				break;
			}

			case MobileMoneyWalletDE:{
				payWithMobileDE(pSenderperson, pReceiver, pvalue);
				break;
			}

			case MobileMoneyWalletEN:{
				payWithMobileEN(pSenderperson, pReceiver, pvalue);
				break;
			}


		}

		return true;
	}
	public Payment getPayment(){
		return payment;
	}
	public Person getReceiver(){
		return pReceiver;
	}
	public Person getSender(){
		return pSender;
	}



}//end PaymentService