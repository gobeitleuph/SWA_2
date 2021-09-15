package Payment;

import Authentication.AuthenticationService;
import Statistics.PaymentVisitor;
import Statistics.Visitor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Payment {

    protected LocalDateTime Date;
    protected Account Receiver;
    protected Account Sender;
    protected CurrencyAmount cvalue = new CurrencyAmount();
    int Value = cvalue.amount;
    AuthenticationService auth;
    String pcredent;

    public abstract void accept(Visitor visitor);







    public Payment() {

        auth = new AuthenticationService();



    }

    public boolean authenticate(Account pSender, Account pReceiver){
        auth.authenticateSubject(Sender.getInhaber(), pcredent);

        return true;
    }

    public abstract boolean Commit();

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
