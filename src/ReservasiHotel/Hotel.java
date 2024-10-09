package ReservasiHotel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();   
        reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("Kamar " + room.getRoomNumber() + " berhasil ditambahkan dengan harga " + room.getPrice());
    }

    public void makeReservation(User customer, int roomNumber, String date) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                reservations.add(new Reservation(customer, room, date));
                room.setAvailable(false);
                System.out.println("Reservasi berhasil untuk Kamar " + roomNumber);
                return;
            }
        }
        System.out.println("Kamar tidak tersedia.");
    }

    public void cancelReservation(User customer, int roomNumber) {
        for (Reservation res : reservations) {
            if (res.getCustomer().equals(customer) && res.getRoom().getRoomNumber() == roomNumber) {
                res.getRoom().setAvailable(true);
                reservations.remove(res);
                System.out.println("Reservasi untuk Kamar " + roomNumber + " berhasil dibatalkan.");
                return;
            }
        }
        System.out.println("Reservasi tidak ditemukan.");
    }

    public void checkRoomAvailability(boolean filterAvailableOnly) {
        System.out.println("Daftar Kamar:");
        if (rooms.isEmpty()) {
            System.out.println("Tidak ada kamar yang tersedia.");
        } else {
            for (Room room : rooms) {
                if (filterAvailableOnly && !room.isAvailable()) {
                    continue;
                }
                System.out.println("Kamar " + room.getRoomNumber() + " - " + 
                                    (room.isAvailable() ? "Tersedia" : "Sudah Dipesan"));
            }
        }
    }

   public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Tidak ada reservasi.");
        } else {
            for (Reservation res : reservations) {
                System.out.println("Reservasi untuk " + res.getCustomer().getUsername() + 
                                   " di Kamar " + res.getRoom().getRoomNumber() + 
                                   " pada " + res.getReservationDate());
            }
        }
    }

    public void filterRoomsByPrice() {
        Collections.sort(rooms, Comparator.comparingDouble(Room::getPrice));
        System.out.println("Kamar berdasarkan harga (termurah ke termahal):");
        for (Room room : rooms) {
            System.out.println("Kamar " + room.getRoomNumber() + " - Harga: " + room.getPrice());
        }
    }
}
