package Content;

import Booking.Booking;

public abstract class Content {
    protected String name;

    public Content(String name) {
        this.name = name;
    }


    public abstract void setName(String name);
    public abstract String getName();

}
