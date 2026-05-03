# SQA Shop - Katalon Automation Testing 🚀

Proyek ini berisi *Automated Test Suite* untuk aplikasi e-commerce **SQA Shop**, yang dibangun menggunakan **Katalon Studio**. Pengujian ini mencakup skenario *End-to-End* (E2E) untuk memastikan kualitas dan fungsionalitas fitur-fitur utama dari web SQA Shop.

## 📋 Daftar Isi
- [Tentang Proyek](#tentang-proyek)
- [Cakupan Pengujian (Test Coverage)](#cakupan-pengujian-test-coverage)
- [Struktur Proyek](#struktur-proyek)
- [Prasyarat Sistem](#prasyarat-sistem)
- [Cara Menjalankan Test](#cara-menjalankan-test)

## 🌐 Tentang Proyek
Proyek ini dibuat untuk melakukan proses *Software Quality Assurance* (SQA) secara otomatis pada platform **SQA Shop**. Semua test case dirancang untuk memvalidasi alur pengguna mulai dari pendaftaran, login, transaksi, hingga logout.

- **Tools yang digunakan:** Katalon Studio
- **Bahasa Script:** Groovy / Java
- **Target Aplikasi:** Web Browser (UI Testing)

## 🎯 Cakupan Pengujian (Test Coverage)
Pengujian pada proyek ini dibagi menjadi beberapa modul utama:

1. **🔑 Authentication (Login & Register)**
   - Registrasi user baru dengan data valid dan invalid.
   - Validasi email dan password saat proses pendaftaran.
   - Login dengan kredensial yang benar maupun salah.
   - Validasi form kosong pada saat otentikasi.

2. **🛒 Shopping Cart (Keranjang Belanja)**
   - Menambahkan produk ke keranjang.
   - Menghapus produk dari keranjang.
   - Menambahkan produk yang sama (validasi kuantitas).
   - Validasi kalkulasi total harga.
   - Cek keamanan akses keranjang tanpa login.

3. **💳 Checkout (Proses Pembayaran)**
   - Checkout dengan berbagai metode pembayaran (COD, E-Wallet, dll).
   - Checkout tanpa alamat atau metode pembayaran.
   - Checkout multiple produk sekaligus.
   - Tambah catatan saat checkout.

4. **📜 Riwayat Transaksi & Logout**
   - Melihat riwayat pesanan (kosong dan terisi).
   - Verifikasi status pemesanan.
   - Proses logout dari aplikasi.
   - Memastikan keamanan halaman (Protected Routes) setelah logout.

## 📁 Struktur Proyek
Berikut adalah struktur direktori utama dari repository ini:
```text
Katalon_SQA_Shop/
├── Test Cases/          # Berisi seluruh skenario pengujian individual (.tc)
│   ├── TC_Checkout/     # Test Cases untuk fitur Checkout
│   ├── TC_Keranjang/    # Test Cases untuk fitur Keranjang
│   ├── TC_Login/        # Test Cases untuk fitur Login
│   ├── TC_Register/     # Test Cases untuk fitur Register
│   └── TC_Riwayat_Logout/ # Test Cases untuk fitur Riwayat & Logout
├── Test Suites/         # Berisi kumpulan Test Case yang dijalankan berurutan (.ts & .tsc)
│   └── TSC_SQA_Shop_Full_Regression.tsc # Test Suite Collection untuk seluruh test
├── Scripts/             # Script Groovy/Java di balik setiap Test Case
├── Object Repository/   # Penyimpanan UI Elements (Web Elements)
└── Profiles/            # Execution profiles (Global Variables)
```

## ⚙️ Prasyarat Sistem
Untuk dapat membuka dan menjalankan proyek ini di lokal, Anda memerlukan:
1. **Katalon Studio** (Versi terbaru direkomendasikan).
2. **Web Browser** terinstal (Google Chrome, Firefox, atau Edge).
3. **Katalon Web Driver** (biasanya akan terupdate secara otomatis dari aplikasi Katalon).

## 🚀 Cara Menjalankan Test

### Melalui UI Katalon Studio:
1. Clone repository ini ke lokal komputer Anda:
   ```bash
   git clone https://github.com/fahmiardiansyahh/sqa_shop_katalon.git
   ```
2. Buka aplikasi **Katalon Studio**.
3. Pilih **File > Open Project** dan arahkan ke folder `Katalon_SQA_Shop`.
4. Buka folder `Test Suites` pada tab *Tests Explorer*.
5. Pilih Test Suite yang ingin dijalankan (contoh: `TS_Login` atau `TSC_SQA_Shop_Full_Regression`).
6. Klik tombol **Run** (Pilih browser yang diinginkan, misal: Chrome).

---
*Dibuat untuk keperluan otomatisasi pengujian Software Quality Assurance (SQA). Universitas Bina Sarana Informatika*
