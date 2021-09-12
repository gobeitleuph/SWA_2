package Booking;


/**
 * @author leona
 * @version 1.0
 * @created 25-Aug-2021 17:56:00
 */
public class GermanBooking extends Booking{

    private  String head;
    private  String body;
    private  String footer;
    private String all;

    public GermanBooking(String head, String footer, String body){
        this.head=head;
        this.body=body;
        this.footer=footer;

        String info = "";
        info += "Das ist der Header:"+ head +"\n";
        info += "Das ist der body:"+ body +"\n";
        info += "Das ist der footer:"+ footer + "\n";
        all=info;

    }
    public String print(){
        String info = "";
        info += "Das ist der Header:"+ head +"\n";
        info += "Das ist der body:"+ body +"\n";
        info += "Das ist der footer:"+ footer + "\n";
        return info;
    }

    public String getAll() {
        return all;
    }
}//end EnglishBooking