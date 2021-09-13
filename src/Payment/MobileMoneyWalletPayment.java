package Payment;

import java.time.LocalDateTime;


public class MobileMoneyWalletPayment extends Payment{


        public MobileMoneyWalletPayment(Account pSender, Account pReceiver, int pValue) {
            super(pSender, pReceiver, pValue);
        }

        @Override
        public boolean Commit() {

                this.Date = LocalDateTime.now();
                Sender.Saldo = Sender.Saldo - Value;
                Receiver.Saldo = Receiver.Saldo + Value;
                System.out.println("Bezahlung wurde mit MobileMoneyWalletPayment am " + getDate() + " ausgeführt.");
                System.out.println("Neuer Kontostand: " + Sender.getSaldo() + "€");

            return true;
        }
    }

