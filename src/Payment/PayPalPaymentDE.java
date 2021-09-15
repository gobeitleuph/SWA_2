package Payment;

import Statistics.Visitor;

import java.time.LocalDateTime;



import Statistics.PaymentVisitor;
import Statistics.Visitor;

import java.time.LocalDateTime;

    public class PayPalPaymentDE extends Payment{

        public int PayPalCounter;
        protected Account Receiver;
        protected Account Sender;

//        public int getPayPalCounter() {
//                return PayPalCounter;
//        }
//
//        private int PayPalCounter = 0;

        public PayPalPaymentDE(Account pSender, Account pReceiver, int pValue) {
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
            System.out.println("Bezahlung wurde mit Paypal am " + getDate() + " ausgeführt.");
            System.out.println("Neuer Kontostand: " + Sender.getSaldo() + "€");

            return true;
        }


    }





