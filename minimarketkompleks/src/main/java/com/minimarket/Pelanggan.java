package com.minimarket;

public class Pelanggan {
    private String username; // Nama pengguna pelanggan
    private String password; // Kata sandi pelanggan
    private double saldo; // Saldo pelanggan

    // Konstruktor untuk membuat objek pelanggan dengan username dan password awal
    public Pelanggan(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 00; // Saldo awal pelanggan diatur ke 0 saat pertama kali dibuat
    }

    // Mengembalikan nama pengguna pelanggan
    public String getUsername() {
        return username;
    }

    // Memeriksa apakah kata sandi yang diberikan cocok dengan kata sandi pelanggan
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    // Mengembalikan saldo pelanggan
    public double getSaldo() {
        return saldo;
    }

    // Mengatur saldo pelanggan
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
