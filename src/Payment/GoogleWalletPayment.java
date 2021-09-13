package Payment;

import java.time.LocalDateTime;

public class GoogleWalletPayment extends Payment{

    public GoogleWalletPayment(Account pSender, Account pReceiver, int pValue) {
        this.Sender = pSender;
        this.Receiver = pReceiver;
        this.Value = pValue;
    }

    @Override
    public boolean Commit() {

        this.Date = LocalDateTime.now();
        Sender.Saldo = Sender.Saldo - Value;
        Receiver.Saldo = Receiver.Saldo + Value;
        System.out.println("Bezahlung wurde mit GoogleWallet am " + getDate() + " ausgeführt.");
        System.out.println("Neuer Kontostand: " + Sender.getSaldo() + "€");

        return true;
    }
}
