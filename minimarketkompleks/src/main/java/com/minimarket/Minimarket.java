package com.minimarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimarket {
    private List<Barang> daftarBarang; // Daftar barang yang tersedia di minimarket
    private Map<Pelanggan, Double> keranjangBelanja; // Daftar belanjaan dan total harga per pelanggan

    public Minimarket() {
        daftarBarang = new ArrayList<>(); // Inisialisasi daftar barang sebagai ArrayList
        keranjangBelanja = new HashMap<>(); // Inisialisasi keranjang belanja sebagai HashMap
    }

    public void tambahBarang(Barang barang) {
        daftarBarang.add(barang); // Menambahkan barang ke daftar barang minimarket
    }

    public void tampilkanBarang() {
        System.out.println("Daftar Barang di Minimarket:");
        for (int i = 0; i < daftarBarang.size(); i++) {
            Barang barang = daftarBarang.get(i);
            System.out.println((i + 1) + ". " + barang.getNama() + " (Harga: RP " + barang.getHarga() + ")");
        }
    }

    public boolean beliBarang(Pelanggan pelanggan, int nomorBarang, int jumlah) {
        if (nomorBarang >= 1 && nomorBarang <= daftarBarang.size()) {
            Barang barang = daftarBarang.get(nomorBarang - 1); // Mengambil barang berdasarkan nomor
            double totalHarga = barang.getHarga() * jumlah; // Menghitung total harga pembelian

            if (pelanggan.getSaldo() >= totalHarga) {
                pelanggan.setSaldo(pelanggan.getSaldo() - totalHarga); // Mengurangi saldo pelanggan
                keranjangBelanja.put(pelanggan, keranjangBelanja.getOrDefault(pelanggan, 0.0) + totalHarga); // Menyimpan
                                                                                                             // total
                                                                                                             // harga ke
                                                                                                             // keranjang
                                                                                                             // belanja
                System.out.println("Pembelian berhasil!"); // Menampilkan pesan pembelian berhasil
                return true;
            } else {
                System.out.println("Saldo tidak mencukupi. Pembelian gagal."); // Menampilkan pesan pembelian gagal
                return false;
            }
        } else {
            System.out.println("Nomor barang tidak valid. Pembelian gagal."); // Menampilkan pesan nomor barang tidak
                                                                              // valid
            return false;
        }
    }

    public void tampilkanKeranjangBelanja(Pelanggan pelanggan) {
        double totalBelanja = keranjangBelanja.getOrDefault(pelanggan, 0.0);
        System.out.println("Keranjang Belanja untuk " + pelanggan.getUsername() + ":");

        System.out.println("Total Pembelian: RP " + totalBelanja);
    }

}
