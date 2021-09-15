package Statistics;

import Payment.GoogleWalletPayment;
import Payment.MobileMoneyWalletPayment;
import Payment.PayPalPaymentEN;
import Payment.PayPalPaymentDE;

public class PaymentVisitor implements Visitor {

    private int PayPalPaymentcountEN;
    private int PayPalPaymentcountDE;

//    private int countDE;
//
//    private int countEN;
//    private int countDE;
//    private int countEN;

//



    public void visit(PayPalPaymentEN payPalPaymentEN) {
        PayPalPaymentcountEN++;
        System.out.println(PayPalPaymentcountEN);

    }

    public void visit(PayPalPaymentDE payPalPayment) {
        PayPalPaymentcountDE++;
        System.out.println(PayPalPaymentcountEN);


    }

    @Override
    public void visit(GoogleWalletPayment googleWalletPayment) {

    }

    @Override
    public void visit(MobileMoneyWalletPayment mobileMoneyWalletPayment) {

    }
}
