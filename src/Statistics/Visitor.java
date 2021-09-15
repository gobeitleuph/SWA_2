package Statistics;

import Payment.GoogleWalletPayment;
import Payment.MobileMoneyWalletPayment;
import Payment.PayPalPaymentEN;
import Payment.PayPalPaymentDE;

public interface Visitor {

    int PayPalPaymentcountEN = 0;

    void visit(PayPalPaymentEN paymentitem);

    void visit(PayPalPaymentDE paymentitem);

    void visit(GoogleWalletPayment googleWalletPayment);



    void visit(MobileMoneyWalletPayment mobileMoneyWalletPayment);

}
