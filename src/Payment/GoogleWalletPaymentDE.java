package Payment;

import Statistics.Visitor;

import java.time.LocalDateTime;

public class GoogleWalletPaymentDE extends Payment{

    public GoogleWalletPaymentDE(Account pSender, Account pReceiver, int pValue) {
        this.Sender = pSender;
        this.Receiver = pReceiver;
        this.Value = pValue;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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

    @Override
    public Account getReceiver(){
        return Receiver;
    }
    @Override
    public Account getSender(){
        return Sender;
    }
}
