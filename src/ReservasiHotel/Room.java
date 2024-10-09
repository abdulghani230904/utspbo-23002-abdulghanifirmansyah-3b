package ReservasiHotel;

public class Room {
    private int roomNumber;
    private boolean isAvailable;
    private double price;

    public Room(int roomNumber, double price) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.isAvailable = true;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public double getPrice() {
        return price;
    }
}
