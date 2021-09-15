package Payment;

import Statistics.PaymentVisitor;
import Statistics.Visitor;

import java.time.LocalDateTime;

public class PayPalPaymentEN extends Payment{

        public int PayPalCounter;
        protected Account Receiver;
        protected Account Sender;

//        public int getPayPalCounter() {
//                return PayPalCounter;
//        }
//
//        private int PayPalCounter = 0;

        public PayPalPaymentEN(Account pSender, Account pReceiver, int pValue) {
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
                System.out.println("Payment was made with Paypal on " + getDate() + " successful");
                System.out.println("New balance:" + Sender.getSaldo() + "€");

                return true;
        }


}



