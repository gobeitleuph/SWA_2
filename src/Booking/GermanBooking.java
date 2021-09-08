package Booking;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class GermanBooking {

    private final String head;
    private final String body;
    private final String footer;

    public GermanBooking(String head, String footer, String body){
        this.head=head;
        this.body=body;
        this.footer=footer;

    }
    public String print(){
        String info = "";
        info += "Das ist der Header:"+ head +"\n";
        info += "Das ist der body:"+ body +"\n";
        info += "Das ist der footer:"+ footer + "\n";
        return info;
    }
}//end EnglishBooking