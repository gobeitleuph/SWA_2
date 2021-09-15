package Statistics;

import Payment.*;

public interface Visitor {

    int PayPalPaymentcountEN = 0;

    void visit(PayPalPaymentDE paymentitem);

    void visit(PayPalPaymentEN paymentitem);

    void visit(GoogleWalletPaymentDE googleWalletPayment);

    void visit(GoogleWalletPaymentEN googleWalletPayment);

    void visit(MobileMoneyWalletPaymentDE mobileMoneyWalletPayment);
    void visit(MobileMoneyWalletPaymentEN mobileMoneyWalletPayment);

}
