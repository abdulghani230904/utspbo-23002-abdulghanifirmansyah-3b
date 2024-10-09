package ReservasiHotel;

public class Reservation {
    private User customer;
    private Room room;
    private String reservationDate;

    public Reservation(User customer, Room room, String reservationDate) {
        this.customer = customer;
        this.room = room;
        this.reservationDate = reservationDate;
        room.setAvailable(false);
    }

    public User getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void cancelReservation() {
        room.setAvailable(true); 
    }
}
