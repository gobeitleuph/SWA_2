package Payment;

import Authentication.AuthenticationService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Payment {

    protected LocalDateTime Date;
    protected Account Receiver;
    protected Account Sender;
    protected int Value;
    AuthenticationService auth;
    String pcredent;







    public Payment(Account pSender, Account pReceiver, int pValue) {
        this.Sender = pSender;
        this.Receiver = pReceiver;
        this.Value = pValue;
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