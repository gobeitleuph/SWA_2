package Content;

import Booking.Booking;

public abstract class Content {
    protected String name;

    public abstract void setName(String name);
    public abstract String getName();
    public abstract void setBooking (Booking booking);

}
