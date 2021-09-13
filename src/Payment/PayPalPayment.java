package Payment;

import java.time.LocalDateTime;

public class PayPalPayment extends Payment{

        protected Account Receiver;
        protected Account Sender;

        public PayPalPayment(Account pSender, Account pReceiver, int pValue) {
                this.Sender = pSender;
                this.Receiver = pReceiver;
                this.Value = pValue;




        }



        @Override
        public boolean Commit() {

                this.Date = LocalDateTime.now();
                Sender.Saldo = Sender.Saldo - Value;
                Receiver.Saldo = Receiver.Saldo + Value;
                System.out.println("Bezahlung wurde mit Paypal am " + getDate() + " ausgeführt.");
                System.out.println("Neuer Kontostand: " + Sender.getSaldo() + "€");

                return true;
        }
    }



