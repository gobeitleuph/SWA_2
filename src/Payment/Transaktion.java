package Payment;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



    public class Transaktion {

        protected LocalDateTime Date;
        protected Account Receiver;
        protected Account Sender;
        protected int Value;

        public Transaktion(Account pSender, Account pReceiver, int pValue) {
            this.Sender = pSender;
            this.Receiver = pReceiver;
            this.Value = pValue;
        }

        public void Commit() {
            this.Date = LocalDateTime.now();
            Sender.Saldo = Sender.Saldo - Value;
            Receiver.Saldo = Receiver.Saldo + Value;
            System.out.println("Überweisung wurde um " + getDate() + " ausgeführt.");
            System.out.println("Neuer Kontostand: " + Sender.getSaldo() + "€");
        }

        public String getDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
            return Date.format(formatter);
        }

        public void setDate(LocalDateTime date) {
            Date = date;
        }

        public Account getReceiver() {
            return Receiver;
        }

        public void setReceiver(Account receiver) {
            Receiver = receiver;
        }

        public Account getSender() {
            return Sender;
        }

        public void setSender(Account sender) {
            Sender = sender;
        }

        public double getValue() {
            return ((double)Value)/100;
        }

        public void setValue(int value) {
            Value = value;
        }

    }

