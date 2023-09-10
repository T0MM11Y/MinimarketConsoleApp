package com.minimarket;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("Tidak dapat membersihkan layar.");
        }
    }

    public static void main(String[] args) {
        Minimarket minimarket = new Minimarket();
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        // Menambahkan beberapa barang ke minimarket
        minimarket.tambahBarang(new Barang("Sabun Lifebuoy", 5000.0));
        minimarket.tambahBarang(new Barang("Shampoo Pantene", 10000.0));
        minimarket.tambahBarang(new Barang("Pasta Gigi Formula", 3000.0));
        minimarket.tambahBarang(new Barang("Minyak Goreng Filma", 15000.0));
        minimarket.tambahBarang(new Barang("Susu Bendera", 7000.0));
        minimarket.tambahBarang(new Barang("Sabun Mandi Lux", 8000.0));
        minimarket.tambahBarang(new Barang("Mie Instant Indomie", 2500.0));
        minimarket.tambahBarang(new Barang("Teh Sariwangi", 4000.0));
        minimarket.tambahBarang(new Barang("Gula Pasir Gulaku", 6000.0));
        minimarket.tambahBarang(new Barang("Kopi Kapal Api", 12000.0));
        minimarket.tambahBarang(new Barang("Tisu Paseo", 4500.0));
        minimarket.tambahBarang(new Barang("Beras Cap Ayam Jago", 25000.0));
        minimarket.tambahBarang(new Barang("Mie Instant ABC", 3000.0));
        minimarket.tambahBarang(new Barang("Garam Dapur", 4000.0));
        minimarket.tambahBarang(new Barang("Kecap Manis ABC", 7000.0));
        minimarket.tambahBarang(new Barang("Susu Ultra Milk", 8000.0));
        minimarket.tambahBarang(new Barang("Kopi ABC", 10000.0));
        minimarket.tambahBarang(new Barang("Sikat Gigi Pepsodent", 5000.0));
        minimarket.tambahBarang(new Barang("Sikat Rambut Paddle", 15000.0));
        minimarket.tambahBarang(new Barang("Telur Ayam Kampung", 18000.0));

        while (true) {
            if (login.getPelangganAktif() == null) {
                clearScreen();
                System.out.println("\nSelamat datang di Minimarket!");
                System.out.println("1. Login");
                System.out.println("2. Register");
                System.out.println("3. Keluar");
                System.out.print("Pilih tindakan (1/2/3): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Membuang newline
                clearScreen();

                switch (choice) {
                    case 1:
                        System.out.print("Masukkan username: ");
                        String username = scanner.nextLine();
                        System.out.print("Masukkan password: ");
                        String password = scanner.nextLine();
                        login.login(username, password);
                        break;
                    case 2:
                        System.out.print("Masukkan username baru: ");
                        username = scanner.nextLine();
                        System.out.print("Masukkan password baru: ");
                        password = scanner.nextLine();
                        login.register(username, password);
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }
                clearScreen();
            } else {
                Pelanggan pelangganAktif = login.getPelangganAktif();
                clearScreen();
                System.out.println("Selamat datang, " + pelangganAktif.getUsername() + "!");
                System.out.println("Saldo Anda: RP " + pelangganAktif.getSaldo());

                // Memeriksa apakah pelanggan memiliki saldo awal
                if (pelangganAktif.getSaldo() == 0) {
                    System.out.print("Masukkan saldo awal Anda: ");
                    double saldoAwal = scanner.nextDouble();
                    pelangganAktif.setSaldo(saldoAwal);
                    clearScreen();
                    System.out.println("Saldo Anda sekarang: RP " + pelangganAktif.getSaldo());
                }

                while (true) { // Tambahkan loop untuk memungkinkan pembelian berulang
                    System.out.println("\nMenu:");
                    System.out.println("1. Tampilkan Barang");
                    System.out.println("2. Beli Barang");
                    System.out.println("3. Tampilkan Keranjang Belanja");
                    System.out.println("4. Logout");
                    System.out.print("Pilih tindakan (1/2/3/4): ");
                    int choice = scanner.nextInt();
                    scanner.nextLine(); // Membuang newline

                    switch (choice) {
                        case 1:
                            clearScreen();
                            minimarket.tampilkanBarang();
                            break;
                        case 2:
                            clearScreen();
                            minimarket.tampilkanBarang();
                            System.out.println("\n");
                            System.out.print("Pilih nomor barang yang ingin dibeli: ");
                            int nomorBarang = scanner.nextInt();
                            System.out.print("Masukkan jumlah yang ingin dibeli: ");
                            int jumlah = scanner.nextInt();
                            boolean pembelianBerhasil = minimarket.beliBarang(pelangganAktif, nomorBarang, jumlah);
                            if (pembelianBerhasil) {
                                clearScreen();

                                System.out.println("Pembelian berhasil!");
                                System.out.println("Sisa Saldo Anda: RP " + pelangganAktif.getSaldo());
                                System.out.println('\n');
                                minimarket.tampilkanKeranjangBelanja(pelangganAktif);
                            } else {
                                clearScreen();

                                System.out.println("Pembelian gagal.");
                            }
                            break;

                        case 3:
                            clearScreen();
                            System.out.println("Saldo Anda: RP " + pelangganAktif.getSaldo());
                            System.out.println('\n');
                            minimarket.tampilkanKeranjangBelanja(pelangganAktif);
                            break;
                        case 4:
                            clearScreen();
                            login.logout();
                            return; // Keluar dari program
                        default:
                            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                            break;
                    }

                    // Periksa apakah saldo masih mencukupi untuk pembelian berikutnya
                    if (pelangganAktif.getSaldo() <= 0) {
                        System.out.println("Saldo Anda habis. Logout.");
                        login.logout();
                        return; // Keluar dari program
                    }
                }
            }
        }
    }
}
