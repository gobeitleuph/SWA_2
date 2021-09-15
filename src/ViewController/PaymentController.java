package ViewController;

import Payment.Payment;
import Payment.PaymentService;
import Payment.PaymentType;
import Person.Person;

public class PaymentController implements CommandController{
    private PaymentType paymentType;
    private Person personSender;
    private Person personReceiver;
    private int value;
    private String credentialIdentifierInput;
    private Payment payment;
    private Person pgetSender;
    private Person pgetReceiver;

    public PaymentController(PaymentType paymentType, Person personSender, Person personReceiver, int value, String credentialIdentifierInput) {
        this.paymentType = paymentType;
        this.personSender = personSender;
        this.personReceiver = personReceiver;
        this.value = value;
        this.credentialIdentifierInput = credentialIdentifierInput;
    }

    @Override
    public void execute(String command) {
        switch (command){
            case "transactPayment":{
                PaymentService paymentService = new PaymentService();
                paymentService.payAmount(paymentType, personSender, personReceiver, value, credentialIdentifierInput);
                this.payment = paymentService.getPayment();
                this.pgetReceiver = paymentService.getReceiver();
                this.pgetSender = paymentService.getSender();
                break;
            }
        }

    }
    public Payment getPayment(){
        return payment;
    }
    public Person getPersonSender(){
        return pgetSender;
    }
    public Person getPersonReceiver(){
        return pgetReceiver;
    }
}
