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
//		Payment payment = new PayPalPaymentEN(pSenderperson.getAccount(), pReceiver.getAccount())
//
//
//
//			}
//			auth.authenticateSubject(Sender.getInhaber(), pcredent);

	public void payWithPaypal(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		Payment payment = new PayPalPaymentEN(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();


	}

	public void payWithGoogle(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		Payment payment = new GoogleWalletPayment(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();

	}

	public void payWithMobile(Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
		Payment payment = new PayPalPaymentEN(pSenderperson.getAccount(),pReceiver.getAccount(), pvalue);
		payment.auth.authenticateSubject(pSenderperson, pcredentialIdentifierInput);
		payment.Commit();

	}


	public boolean payAmount(PaymentType ptype,Person pSenderperson, Person pReceiver, int pvalue, String pcredentialIdentifierInput){
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




}//end PaymentService