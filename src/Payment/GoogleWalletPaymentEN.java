package Payment;

import Statistics.Visitor;

import java.time.LocalDateTime;



import Statistics.Visitor;

import java.time.LocalDateTime;

    public class GoogleWalletPaymentEN extends Payment{

        public GoogleWalletPaymentEN(Account pSender, Account pReceiver, int pValue) {
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
            System.out.println("Payment was made with GoogleWallet on " + getDate() );
            System.out.println("New balance: " + Sender.getSaldo() + "€");

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


