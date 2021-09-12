package Payment;


import java.util.ArrayList;

/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:01
 */
public class PaymentService extends APaymentService {


	private static ArrayList<Account> Account = new ArrayList<Account>();

	private static final String FILE_NAME = "Konten.csv";


	public PaymentService(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}
	protected void authenticate(){
		Payment payment = new Payment(Account pSender, Account pReceiver) {
		auth.authenticateSubject(Sender.getInhaber(), pcredent);

		}
	}

	protected void confirmation(){

	}

	public boolean payAmount(){
		return false;
	}

	protected void transact(){

	}
}//end PaymentService