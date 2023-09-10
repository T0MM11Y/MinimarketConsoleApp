package com.minimarket;

import java.util.HashMap;
import java.util.Map;

// Kelas Login digunakan untuk mengelola login, registrasi, dan logout pelanggan.
public class Login {
    private Map<String, Pelanggan> databasePelanggan; // Database untuk menyimpan informasi pelanggan
    private Pelanggan pelangganAktif; // Pelanggan yang sedang login

    // Konstruktor untuk membuat objek Login.
    public Login() {
        databasePelanggan = new HashMap<>();
    }

    // Metode untuk melakukan login berdasarkan username dan password.
    public boolean login(String username, String password) {
        if (databasePelanggan.containsKey(username)) {
            Pelanggan pelanggan = databasePelanggan.get(username);
            if (pelanggan.checkPassword(password)) {
                pelangganAktif = pelanggan;
                System.out.println("Login berhasil.");
                return true;
            }
        }
        System.out.println("Login gagal. Periksa kembali username dan password.");
        return false;
    }

    // Metode untuk melakukan registrasi dengan username dan password baru.
    public void register(String username, String password) {
        if (!databasePelanggan.containsKey(username)) {
            Pelanggan pelanggan = new Pelanggan(username, password);
            databasePelanggan.put(username, pelanggan);
            System.out.println("Registrasi berhasil. Silakan login.");
        } else {
            System.out.println("Username sudah digunakan. Registrasi gagal.");
        }
    }

    // Metode untuk melakukan logout.
    public void logout() {
        pelangganAktif = null;
        System.out.println("Logout berhasil.");
    }

    // Metode untuk mendapatkan pelanggan yang sedang aktif (login).
    public Pelanggan getPelangganAktif() {
        return pelangganAktif;
    }
}
