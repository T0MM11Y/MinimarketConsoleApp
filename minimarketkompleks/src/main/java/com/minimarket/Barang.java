package com.minimarket;

// Kelas Barang merepresentasikan barang yang dijual di minimarket.
class Barang {
    private String nama; // Variabel untuk menyimpan nama barang.
    private double harga; // Variabel untuk menyimpan harga barang.

    // Konstruktor untuk membuat objek Barang dengan nama dan harga awal.
    public Barang(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    // method untuk mendapatkan nama barang.
    public String getNama() {
        return nama;
    }

    // method untuk mendapatkan harga barang.
    public double getHarga() {
        return harga;
    }

    // method yang mengganti representasi String dari objek Barang.
    @Override
    public String toString() {
        return nama + " (Harga: " + harga + ")";
    }
}
