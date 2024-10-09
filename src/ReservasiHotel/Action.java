package ReservasiHotel;

import java.util.Scanner;

public class Action {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hotel hotel = new Hotel();

        hotel.addRoom(new Room(101, 200000));
        hotel.addRoom(new Room(102, 300000));
        hotel.addRoom(new Room(103, 400000));
        
        User admin = new User("admin", "admin");
        User customer = new User("Aslab_baik", "customer");
        
        do{

            System.out.println("Login sebagai (1) Admin atau (2) Customer?");
            int userType = sc.nextInt();
            User currentUser;

            if (userType == 1) {
                currentUser = admin;
            } else {
                currentUser = customer;
            }

            System.out.println("Welcome, " + currentUser.getUsername() + " (" + currentUser.getRole() + ")");

            boolean running = true;

            while (running) {
                if (currentUser.getRole().equals("admin")) {

                    System.out.println("Admin Menu:");
                    System.out.println("1. Tambah Kamar");
                    System.out.println("2. Lihat Reservasi");
                    System.out.println("3. Lihat Ketersediaan Kamar");
                    System.out.println("4. Keluar");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Masukkan nomor kamar:");
                            int roomNumber = sc.nextInt();
                            System.out.println("Masukkan harga kamar:");
                            double price = sc.nextDouble();
                            hotel.addRoom(new Room(roomNumber, price));
                            hotel.checkRoomAvailability(false);
                            break;

                        case 2:
                            hotel.viewReservations();
                            break;

                        case 3:
                            hotel.checkRoomAvailability(false);
                            break;

                        case 4:
                            running = false;
                            System.out.println("Keluar dari admin...");
                            break;

                        default:
                            System.out.println("Pilihan tidak valid.");
                    }
                } else if (currentUser.getRole().equals("customer")) {
                    // Menu untuk Customer
                    System.out.println("Customer Menu:");
                    System.out.println("1. Pesan Kamar");
                    System.out.println("2. Lihat Ketersediaan Kamar (Tersedia saja)");
                    System.out.println("3. Batalkan Reservasi");
                    System.out.println("4. Lihat Kamar Berdasarkan Harga");
                    System.out.println("5. Keluar");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("Masukkan nomor kamar yang ingin dipesan:");
                            int roomNumber = sc.nextInt();
                            System.out.println("Masukkan tanggal reservasi (dd-mm-yyyy):");
                            String date = sc.next();
                            hotel.makeReservation(currentUser, roomNumber, date);
                            break;

                        case 2:
                            hotel.checkRoomAvailability(true);
                            break;

                        case 3:
                            System.out.println("Masukkan nomor kamar yang ingin dibatalkan:");
                            int cancelRoomNumber = sc.nextInt();
                            hotel.cancelReservation(currentUser, cancelRoomNumber);
                            break;

                        case 4:
                            hotel.filterRoomsByPrice();
                            break;

                        case 5:
                            running = false;
                            System.out.println("Keluar dari customer...");
                            break;

                        default:

                            System.out.println("Pilihan tidak valid.");
                    }
                }
            }
        }while(true);

       
    }
}