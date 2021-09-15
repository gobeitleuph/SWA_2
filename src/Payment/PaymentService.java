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

	public void payWithPaypal(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		this.payment = new PayPalPayment(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());

	}

	public void payWithGoogle(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		this.payment = new GoogleWalletPayment(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}

	public void payWithMobile(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		this.payment = new PayPalPayment(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();
		this.pReceiver.setAccount(payment.getReceiver());
		this.pSender.setAccount(payment.getSender());
	}


	public boolean payAmount(PaymentType ptype,Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		this.pSender = pSenderperson;
		this.pReceiver = pReceiver;


		switch (ptype){

			case PayPal :{
				payWithPaypal(pSenderperson, pReceiver, pvalue, pcredentialIdentifierInput);
				break;
			}

			case GoogleWallet:{
				payWithGoogle(pSenderperson, pReceiver, pvalue, pcredentialIdentifierInput);
				break;
			}

			case MobileMoneyWallet:{
				payWithMobile(pSenderperson, pReceiver, pvalue, pcredentialIdentifierInput);
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