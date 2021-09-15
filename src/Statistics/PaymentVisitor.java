package Statistics;

import Payment.*;

public class PaymentVisitor implements Visitor {

    private int PayPalPaymentcountEN;

    public int getPayPalPaymentcountEN() {
        return PayPalPaymentcountEN;
    }

    public int getPayPalPaymentcountDE() {
        return PayPalPaymentcountDE;
    }

    public int getGoogleWalletPaymentDEcountDE() {
        return GoogleWalletPaymentDEcountDE;
    }

    public int getGoogleWalletPaymentENcountEN() {
        return GoogleWalletPaymentENcountEN;
    }

    public int getMobileMoneyWalletPaymentDE() {
        return MobileMoneyWalletPaymentDE;
    }

    public int getMobileMoneyWalletPaymentEN() {
        return MobileMoneyWalletPaymentEN;
    }

    private int PayPalPaymentcountDE;
    private int GoogleWalletPaymentDEcountDE;
    private int GoogleWalletPaymentENcountEN;
    private int MobileMoneyWalletPaymentDE;
    private int MobileMoneyWalletPaymentEN;

//    private int countDE;
//
//    private int countEN;
//    private int countDE;
//    private int countEN;

//

    public void visit(PayPalPaymentDE payPalPayment) {
        PayPalPaymentcountDE++;
        System.out.println(PayPalPaymentcountDE);

    }

    public void visit(PayPalPaymentEN payPalPaymentEN) {
        PayPalPaymentcountEN++;
        System.out.println(PayPalPaymentcountEN);

    }

    @Override
    public void visit(GoogleWalletPaymentDE googleWalletPaymentDE) {
        GoogleWalletPaymentDEcountDE++;
        System.out.println(GoogleWalletPaymentDEcountDE);
    }

    @Override
    public void visit(GoogleWalletPaymentEN googleWalletPayment) {
        GoogleWalletPaymentENcountEN++;
        System.out.println(GoogleWalletPaymentENcountEN);
    }

    @Override
    public void visit(MobileMoneyWalletPaymentDE mobileMoneyWalletPayment) {
        MobileMoneyWalletPaymentDE++;
        System.out.println(MobileMoneyWalletPaymentDE);
    }



    public void visit(MobileMoneyWalletPaymentEN mobileMoneyWalletPayment) {
        MobileMoneyWalletPaymentEN++;
        System.out.println(MobileMoneyWalletPaymentEN);
    }


}
