# MinimarketConsoleAppWithJava

// Deskripsi Kelas //

--- Kelas Barang ---


Kelas Barang digunakan untuk merepresentasikan barang yang dijual di minimarket. Kelas ini
memiliki dua atribut utama:
 nama: Variabel untuk menyimpan nama barang.
 harga: Variabel untuk menyimpan harga barang.
Kelas ini juga memiliki beberapa method penting:
 getNama(): Method untuk mendapatkan nama barang.
 getHarga(): Method untuk mendapatkan harga barang.
 toString(): Method yang mengganti representasi String dari objek Barang.

  --- Kelas Login ---

  
Kelas Login bertanggung jawab untuk mengelola login, registrasi, dan logout pelanggan. Kelas ini
memiliki beberapa atribut utama:
 databasePelanggan: Database untuk menyimpan informasi pelanggan.
 pelangganAktif: Pelanggan yang sedang login.
Kelas ini memiliki beberapa method penting:
 login(String username, String password): Metode untuk melakukan login berdasarkan
username dan password.
 register(String username, String password): Metode untuk melakukan registrasi dengan
username dan password baru.
 logout(): Metode untuk melakukan logout.
 getPelangganAktif(): Metode untuk mendapatkan pelanggan yang sedang aktif (login).

--- Kelas Minimarket---


Kelas Minimarket digunakan untuk mengelola daftar barang yang tersedia di minimarket dan
keranjang belanja pelanggan. Kelas ini memiliki dua atribut utama:
 daftarBarang: Daftar barang yang tersedia di minimarket.
Laporan Praktikum Christian Yehezkil Gultom ~ 11322036 3
 keranjangBelanja: Daftar belanjaan dan total harga per pelanggan.
Kelas ini memiliki beberapa method penting:
 tambahBarang(Barang barang): Menambahkan barang ke daftar barang minimarket.
 tampilkanBarang(): Menampilkan daftar barang yang tersedia.
 beliBarang(Pelanggan pelanggan, int nomorBarang, int jumlah): Memungkinkan
pelanggan untuk membeli barang.
 tampilkanKeranjangBelanja(Pelanggan pelanggan): Menampilkan keranjang belanja
pelanggan.

--- Kelas Pelanggan ---


Kelas Pelanggan digunakan untuk merepresentasikan pelanggan yang melakukan login ke sistem.
Kelas ini memiliki tiga atribut utama:
 username: Nama pengguna pelanggan.
 password: Kata sandi pelanggan.
 saldo: Saldo pelanggan.
Kelas ini memiliki beberapa method penting:
 getUsername(): Mengembalikan nama pengguna pelanggan.
 checkPassword(String password): Memeriksa apakah kata sandi yang diberikan cocok
dengan kata sandi pelanggan.
 getSaldo(): Mengembalikan saldo pelanggan.
 setSaldo(double saldo): Mengatur saldo pelanggan.

/// Alur Penggunaan Program ///

--- Login dan Registrasi ---

1. Pengguna dapat memilih untuk melakukan login atau registrasi.
2. Jika pengguna memilih login, pengguna diminta untuk memasukkan username dan password.
3. Jika pengguna memilih registrasi, pengguna diminta untuk memasukkan username dan
password baru.
4. Sistem akan memverifikasi informasi pengguna dan memberikan pesan sesuai hasilnya.
Menampilkan Barang
1. Pengguna yang telah login dapat melihat daftar barang yang tersedia di minimarket.
2. Daftar barang ditampilkan dengan nomor urut, nama barang, dan harga.
Laporan Praktikum Christian Yehezkil Gultom ~ 11322036 4
Pembelian Barang
1. Pengguna yang telah login dapat memilih barang yang ingin dibeli.
2. Pengguna diminta untuk memasukkan nomor barang dan jumlah yang ingin dibeli.
3. Sistem akan memproses pembelian dan mengurangkan saldo pelanggan jika pembelian
berhasil.
4. Pengguna akan menerima konfirmasi pembelian.
Menampilkan Keranjang Belanja
1. Pengguna yang telah login dapat melihat keranjang belanja mereka.
2. Keranjang belanja akan menampilkan total harga pembelian pelanggan.
Logout
1. Pengguna dapat melakukan logout kapan saja.

/// Kesimpulan ///

Program minimarket ini telah dirancang dengan baik untuk mengelola transaksi jual beli barang di
minimarket virtual. Dengan menggunakan sejumlah kelas yang terstruktur, program ini
memungkinkan pelanggan untuk login, melihat daftar barang, membeli barang, dan melihat keranjang
belanja mereka. Program ini juga memberikan lapisan keamanan dengan mengelola login pelanggan
dan penggunaan saldo
