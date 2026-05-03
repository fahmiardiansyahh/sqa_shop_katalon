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

## 📊 Test Cases & Test Data

Berikut adalah rincian Test Case dan Test Data yang digunakan dalam pengujian ini:

### TC - Register

| TC-ID      | Module   | Test Case Description                                              | Pre-Condition                         | Test Steps                               | Test Data                | Expected Result                                                | Priority   |
|:-----------|:---------|:-------------------------------------------------------------------|:--------------------------------------|:-----------------------------------------|:-------------------------|:---------------------------------------------------------------|:-----------|
| TC-REG-001 | Register | Registrasi dengan semua data valid                                 | Halaman register terbuka, belum login | 1. Buka register.php                     | Nama: Budi Santoso       | Registrasi berhasil, redirect ke login.php dengan pesan sukses | High       |
|            |          |                                                                    |                                       | 2. Isi Nama Lengkap                      | Email: budi@test.com     |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi Email                             | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Isi Password                          | Konfirmasi: Test1234     |                                                                |            |
|            |          |                                                                    |                                       | 5. Isi Konfirmasi Password               | Telp: 081234567890       |                                                                |            |
|            |          |                                                                    |                                       | 6. Isi No Telepon                        | Alamat: Jl. Merdeka No.1 |                                                                |            |
|            |          |                                                                    |                                       | 7. Isi Alamat                            |                          |                                                                |            |
|            |          |                                                                    |                                       | 8. Klik tombol Daftar                    |                          |                                                                |            |
| TC-REG-002 | Register | Registrasi tanpa mengisi nama lengkap                              | Halaman register terbuka              | 1. Buka register.php                     | Nama: (kosong)           | Validasi error, muncul pesan 'Nama minimal 3 karakter'         | High       |
|            |          |                                                                    |                                       | 2. Kosongkan Nama Lengkap                | Email: test2@test.com    |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain dengan valid           | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
| TC-REG-003 | Register | Registrasi dengan nama kurang dari 3 karakter                      | Halaman register terbuka              | 1. Buka register.php                     | Nama: Ab                 | Validasi error, muncul pesan 'Nama minimal 3 karakter'         | Medium     |
|            |          |                                                                    |                                       | 2. Isi Nama: 'Ab'                        | Email: test3@test.com    |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain valid                  | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
| TC-REG-004 | Register | Registrasi dengan format email tidak valid                         | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Validasi error, muncul pesan 'Format email tidak valid'        | High       |
|            |          |                                                                    |                                       | 2. Isi Email dengan format salah         | Email: emailtanpaat      |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain valid                  | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
| TC-REG-005 | Register | Registrasi dengan email yang sudah terdaftar                       | Email budi@test.com sudah terdaftar   | 1. Buka register.php                     | Nama: Budi Dua           | Muncul pesan error 'Email sudah terdaftar'                     | High       |
|            |          |                                                                    |                                       | 2. Isi Email yang sudah ada              | Email: budi@test.com     |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain valid                  | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
| TC-REG-006 | Register | Registrasi dengan password kurang dari 6 karakter                  | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Validasi error, muncul pesan 'Password minimal 6 karakter'     | High       |
|            |          |                                                                    |                                       | 2. Isi Password < 6 karakter             | Email: test6@test.com    |                                                                |            |
|            |          |                                                                    |                                       | 3. Klik Daftar                           | Password: 123            |                                                                |            |
|            |          |                                                                    |                                       |                                          | Konfirmasi: 123          |                                                                |            |
| TC-REG-007 | Register | Registrasi dengan konfirmasi password tidak cocok                  | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Validasi error, muncul pesan 'Password tidak cocok'            | High       |
|            |          |                                                                    |                                       | 2. Isi Password dan Konfirmasi berbeda   | Email: test7@test.com    |                                                                |            |
|            |          |                                                                    |                                       | 3. Klik Daftar                           | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       |                                          | Konfirmasi: Test5678     |                                                                |            |
| TC-REG-008 | Register | Registrasi tanpa mengisi email                                     | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Validasi error, field email required                           | High       |
|            |          |                                                                    |                                       | 2. Kosongkan Email                       | Email: (kosong)          |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain valid                  | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
| TC-REG-009 | Register | Registrasi dengan nomor telepon tidak valid (kurang dari 10 digit) | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Validasi error, muncul pesan 'No telepon harus 10-15 digit'    | Medium     |
|            |          |                                                                    |                                       | 2. Isi No Telp < 10 digit                | Email: test9@test.com    |                                                                |            |
|            |          |                                                                    |                                       | 3. Isi field lain valid                  | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
|            |          |                                                                    |                                       |                                          | Telp: 0812               |                                                                |            |
| TC-REG-010 | Register | Registrasi tanpa mengisi field opsional (alamat & telp)            | Halaman register terbuka              | 1. Buka register.php                     | Nama: Test User          | Registrasi berhasil karena alamat dan telepon opsional         | Medium     |
|            |          |                                                                    |                                       | 2. Isi Nama, Email, Password, Konfirmasi | Email: test10@test.com   |                                                                |            |
|            |          |                                                                    |                                       | 3. Kosongkan Alamat dan Telp             | Password: Test1234       |                                                                |            |
|            |          |                                                                    |                                       | 4. Klik Daftar                           | Konfirmasi: Test1234     |                                                                |            |
|            |          |                                                                    |                                       |                                          | Telp: (kosong)           |                                                                |            |
|            |          |                                                                    |                                       |                                          | Alamat: (kosong)         |                                                                |            |

### TC - Login

| TC-ID      | Module   | Test Case Description                   | Pre-Condition                      | Test Steps                        | Test Data                | Expected Result                                                   | Priority   |
|:-----------|:---------|:----------------------------------------|:-----------------------------------|:----------------------------------|:-------------------------|:------------------------------------------------------------------|:-----------|
| TC-LOG-001 | Login    | Login dengan email dan password valid   | Akun budi@test.com sudah terdaftar | 1. Buka login.php                 | Email: budi@test.com     | Login berhasil, redirect ke index.php, nama user tampil di navbar | High       |
|            |          |                                         |                                    | 2. Isi Email                      | Password: Test1234       |                                                                   |            |
|            |          |                                         |                                    | 3. Isi Password                   |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-002 | Login    | Login dengan email yang tidak terdaftar | Halaman login terbuka              | 1. Buka login.php                 | Email: tidakada@test.com | Muncul pesan error 'Email atau password salah'                    | High       |
|            |          |                                         |                                    | 2. Isi Email yang belum terdaftar | Password: Test1234       |                                                                   |            |
|            |          |                                         |                                    | 3. Isi Password                   |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-003 | Login    | Login dengan password salah             | Akun budi@test.com sudah terdaftar | 1. Buka login.php                 | Email: budi@test.com     | Muncul pesan error 'Email atau password salah'                    | High       |
|            |          |                                         |                                    | 2. Isi Email valid                | Password: SalahPassword  |                                                                   |            |
|            |          |                                         |                                    | 3. Isi Password salah             |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-004 | Login    | Login tanpa mengisi email               | Halaman login terbuka              | 1. Buka login.php                 | Email: (kosong)          | Validasi error, muncul pesan 'Email wajib diisi'                  | High       |
|            |          |                                         |                                    | 2. Kosongkan Email                | Password: Test1234       |                                                                   |            |
|            |          |                                         |                                    | 3. Isi Password                   |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-005 | Login    | Login tanpa mengisi password            | Halaman login terbuka              | 1. Buka login.php                 | Email: budi@test.com     | Validasi error, muncul pesan 'Password wajib diisi'               | High       |
|            |          |                                         |                                    | 2. Isi Email                      | Password: (kosong)       |                                                                   |            |
|            |          |                                         |                                    | 3. Kosongkan Password             |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-006 | Login    | Login tanpa mengisi semua field         | Halaman login terbuka              | 1. Buka login.php                 | Email: (kosong)          | Validasi error pada kedua field                                   | Medium     |
|            |          |                                         |                                    | 2. Kosongkan Email dan Password   | Password: (kosong)       |                                                                   |            |
|            |          |                                         |                                    | 3. Klik Login                     |                          |                                                                   |            |
| TC-LOG-007 | Login    | Login dengan format email tidak valid   | Halaman login terbuka              | 1. Buka login.php                 | Email: buditest          | Validasi error format email                                       | Medium     |
|            |          |                                         |                                    | 2. Isi Email tanpa @              | Password: Test1234       |                                                                   |            |
|            |          |                                         |                                    | 3. Isi Password                   |                          |                                                                   |            |
|            |          |                                         |                                    | 4. Klik Login                     |                          |                                                                   |            |
| TC-LOG-008 | Login    | Akses halaman login saat sudah login    | User sudah login                   | 1. Login terlebih dahulu          | nan                      | Redirect otomatis ke index.php                                    | Medium     |
|            |          |                                         |                                    | 2. Akses login.php secara manual  |                          |                                                                   |            |

### TC - Checkout

| TC-ID      | Module   | Test Case Description                          | Pre-Condition                                       | Test Steps                                 | Test Data                           | Expected Result                                                            | Priority   |
|:-----------|:---------|:-----------------------------------------------|:----------------------------------------------------|:-------------------------------------------|:------------------------------------|:---------------------------------------------------------------------------|:-----------|
| TC-CHK-001 | Checkout | Checkout dengan data lengkap dan valid         | User sudah login, keranjang berisi minimal 1 produk | 1. Tambah produk ke keranjang              | Alamat: Jl. Merdeka No.1 Jakarta    | Pesanan berhasil dibuat, redirect ke riwayat.php, keranjang dikosongkan    | High       |
|            |          |                                                |                                                     | 2. Buka checkout.php                       | Metode: Transfer Bank               |                                                                            |            |
|            |          |                                                |                                                     | 3. Isi Alamat Pengiriman                   | Produk: Laptop Gaming Pro x1        |                                                                            |            |
|            |          |                                                |                                                     | 4. Pilih Metode Pembayaran                 |                                     |                                                                            |            |
|            |          |                                                |                                                     | 5. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-002 | Checkout | Checkout tanpa mengisi alamat pengiriman       | User sudah login, keranjang berisi produk           | 1. Buka checkout.php                       | Alamat: (kosong)                    | Validasi error, muncul pesan 'Alamat minimal 10 karakter'                  | High       |
|            |          |                                                |                                                     | 2. Kosongkan Alamat                        | Metode: COD                         |                                                                            |            |
|            |          |                                                |                                                     | 3. Pilih Metode Pembayaran                 |                                     |                                                                            |            |
|            |          |                                                |                                                     | 4. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-003 | Checkout | Checkout tanpa memilih metode pembayaran       | User sudah login, keranjang berisi produk           | 1. Buka checkout.php                       | Alamat: Jl. Merdeka No.1 Jakarta    | Validasi error, muncul pesan 'Pilih metode pembayaran'                     | High       |
|            |          |                                                |                                                     | 2. Isi Alamat                              | Metode: (tidak dipilih)             |                                                                            |            |
|            |          |                                                |                                                     | 3. Tidak memilih metode                    |                                     |                                                                            |            |
|            |          |                                                |                                                     | 4. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-004 | Checkout | Checkout dengan keranjang kosong               | User sudah login, keranjang kosong                  | 1. Buka checkout.php tanpa menambah produk | Alamat: Jl. Test                    | Muncul pesan error 'Keranjang kosong'                                      | High       |
|            |          |                                                |                                                     | 2. Isi form                                | Metode: Transfer Bank               |                                                                            |            |
|            |          |                                                |                                                     | 3. Klik Buat Pesanan                       | Keranjang: (kosong)                 |                                                                            |            |
| TC-CHK-005 | Checkout | Checkout dengan metode pembayaran COD          | User login, keranjang berisi produk                 | 1. Tambah produk                           | Alamat: Jl. Test No.5               | Pesanan berhasil, metode tercatat sebagai COD di riwayat                   | Medium     |
|            |          |                                                |                                                     | 2. Buka checkout.php                       | Metode: COD                         |                                                                            |            |
|            |          |                                                |                                                     | 3. Isi Alamat                              | Produk: Headphone Wireless X x2     |                                                                            |            |
|            |          |                                                |                                                     | 4. Pilih COD                               |                                     |                                                                            |            |
|            |          |                                                |                                                     | 5. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-006 | Checkout | Checkout dengan metode pembayaran E-Wallet     | User login, keranjang berisi produk                 | 1. Tambah produk                           | Alamat: Jl. Test No.10              | Pesanan berhasil, metode tercatat sebagai E-Wallet di riwayat              | Medium     |
|            |          |                                                |                                                     | 2. Buka checkout.php                       | Metode: E-Wallet                    |                                                                            |            |
|            |          |                                                |                                                     | 3. Isi Alamat                              | Produk: Mouse Gaming x1             |                                                                            |            |
|            |          |                                                |                                                     | 4. Pilih E-Wallet                          |                                     |                                                                            |            |
|            |          |                                                |                                                     | 5. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-007 | Checkout | Checkout dengan alamat kurang dari 10 karakter | User login, keranjang berisi produk                 | 1. Buka checkout.php                       | Alamat: Jl. A                       | Validasi error, 'Alamat minimal 10 karakter'                               | Medium     |
|            |          |                                                |                                                     | 2. Isi Alamat < 10 karakter                | Metode: Transfer Bank               |                                                                            |            |
|            |          |                                                |                                                     | 3. Pilih metode                            |                                     |                                                                            |            |
|            |          |                                                |                                                     | 4. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-008 | Checkout | Checkout dengan catatan opsional               | User login, keranjang berisi produk                 | 1. Tambah produk                           | Alamat: Jl. Merdeka No.1 Jakarta    | Pesanan berhasil, catatan tersimpan di database                            | Low        |
|            |          |                                                |                                                     | 2. Buka checkout.php                       | Metode: Transfer Bank               |                                                                            |            |
|            |          |                                                |                                                     | 3. Isi semua field + catatan               | Catatan: Tolong packing bubble wrap |                                                                            |            |
|            |          |                                                |                                                     | 4. Klik Buat Pesanan                       |                                     |                                                                            |            |
| TC-CHK-009 | Checkout | Akses halaman checkout tanpa login             | User belum login                                    | 1. Buka checkout.php tanpa login           | nan                                 | Redirect otomatis ke login.php                                             | High       |
| TC-CHK-010 | Checkout | Checkout dengan multiple produk berbeda        | User login                                          | 1. Tambah 3 produk berbeda                 | Produk 1: Laptop x1                 | Pesanan berhasil, semua item tercatat di order_items, total dihitung benar | High       |
|            |          |                                                |                                                     | 2. Buka checkout.php                       | Produk 2: Headphone x2              |                                                                            |            |
|            |          |                                                |                                                     | 3. Isi form lengkap                        | Produk 3: Mouse x1                  |                                                                            |            |
|            |          |                                                |                                                     | 4. Klik Buat Pesanan                       | Alamat: Jl. Merdeka No.1            |                                                                            |            |
|            |          |                                                |                                                     |                                            | Metode: Transfer Bank               |                                                                            |            |

### TC - Keranjang

| TC-ID      | Module    | Test Case Description                                      | Pre-Condition                             | Test Steps                                                 | Test Data                              | Expected Result                                                         | Priority   |
|:-----------|:----------|:-----------------------------------------------------------|:------------------------------------------|:-----------------------------------------------------------|:---------------------------------------|:------------------------------------------------------------------------|:-----------|
| TC-CRT-001 | Keranjang | Tambah produk ke keranjang                                 | User sudah login, halaman beranda terbuka | 1. Buka index.php                                          | Produk: Laptop Gaming Pro              | Produk ditambahkan, badge keranjang bertambah, muncul notifikasi sukses | High       |
|            |           |                                                            |                                           | 2. Klik 'Tambah ke Keranjang' pada produk                  |                                        |                                                                         |            |
| TC-CRT-002 | Keranjang | Tambah produk yang sama dua kali                           | User sudah login                          | 1. Klik 'Tambah ke Keranjang' pada produk yang sama 2 kali | Produk: Headphone Wireless X (klik 2x) | Jumlah produk di keranjang bertambah menjadi 2                          | Medium     |
| TC-CRT-003 | Keranjang | Hapus produk dari keranjang                                | Keranjang berisi minimal 1 produk         | 1. Buka checkout.php                                       | Produk di keranjang: Laptop Gaming Pro | Produk terhapus dari keranjang, total diperbarui                        | High       |
|            |           |                                                            |                                           | 2. Klik tombol hapus pada item                             |                                        |                                                                         |            |
| TC-CRT-004 | Keranjang | Cek total harga keranjang                                  | Keranjang berisi beberapa produk          | 1. Tambah Laptop (Rp15.500.000)                            | Laptop x1 + Headphone x1               | Total: Rp 16.750.000 (terhitung benar)                                  | High       |
|            |           |                                                            |                                           | 2. Tambah Headphone (Rp1.250.000)                          |                                        |                                                                         |            |
|            |           |                                                            |                                           | 3. Buka checkout.php                                       |                                        |                                                                         |            |
| TC-CRT-005 | Keranjang | Tombol 'Tambah ke Keranjang' tidak muncul jika belum login | User belum login                          | 1. Buka index.php tanpa login                              | nan                                    | Tombol berubah menjadi 'Login untuk Membeli'                            | Medium     |
|            |           |                                                            |                                           | 2. Periksa tombol pada produk                              |                                        |                                                                         |            |

### TC - Riwayat & Logout

| TC-ID          | Module   | Test Case Description                         | Pre-Condition                    | Test Steps                          | Expected Result                                                                | Priority   |
|:---------------|:---------|:----------------------------------------------|:---------------------------------|:------------------------------------|:-------------------------------------------------------------------------------|:-----------|
| TC-RIW-001     | Riwayat  | Melihat riwayat pesanan setelah checkout      | User sudah melakukan checkout    | 1. Buka riwayat.php                 | Daftar pesanan tampil dengan detail item, total, status, dan metode pembayaran | High       |
| TC-RIW-002     | Riwayat  | Riwayat kosong jika belum pernah checkout     | User baru, belum pernah checkout | 1. Login                            | Muncul pesan 'Belum ada pesanan. Mulai belanja'                                | Medium     |
|                |          |                                               |                                  | 2. Buka riwayat.php                 |                                                                                |            |
| TC-RIW-003     | Riwayat  | Akses riwayat tanpa login                     | User belum login                 | 1. Buka riwayat.php tanpa login     | Redirect otomatis ke login.php                                                 | High       |
| TC-RIW-004     | Riwayat  | Verifikasi status pesanan tampil dengan benar | Pesanan sudah ada                | 1. Buka riwayat.php                 | Status 'Pending' tampil dengan badge warna kuning (warning)                    | Medium     |
|                |          |                                               |                                  | 2. Periksa badge status             |                                                                                |            |
| TC-LOG-OUT-001 | Logout   | Logout dari sistem                            | User sudah login                 | 1. Klik tombol Logout di navbar     | Sesi berakhir, redirect ke login.php, tidak bisa akses halaman protected       | High       |
| TC-LOG-OUT-002 | Logout   | Akses halaman protected setelah logout        | User sudah logout                | 1. Logout                           | Redirect ke login.php                                                          | High       |
|                |          |                                               |                                  | 2. Akses checkout.php secara manual |                                                                                |            |

### Test Data

|   No | Data Category   | Field               | Valid Data                                  | Invalid Data                            | Keterangan                  |
|-----:|:----------------|:--------------------|:--------------------------------------------|:----------------------------------------|:----------------------------|
|    1 | Register        | Nama Lengkap        | Budi Santoso                                | (kosong) / Ab                           | Minimal 3 karakter          |
|    2 | Register        | Email               | budi@test.com                               | emailtanpaat / budi@test.com (duplikat) | Format email valid, unik    |
|    3 | Register        | Password            | Test1234                                    | 123 / (kosong)                          | Minimal 6 karakter          |
|    4 | Register        | Konfirmasi Password | Test1234 (sama dengan password)             | Test5678 (beda)                         | Harus cocok dengan password |
|    5 | Register        | No Telepon          | 081234567890                                | 0812 / abc                              | 10-15 digit angka, opsional |
|    6 | Register        | Alamat              | Jl. Merdeka No.1, Jakarta Pusat             | (kosong)                                | Opsional                    |
|    7 | Login           | Email               | budi@test.com                               | tidakada@test.com / emailtanpaat        | Harus terdaftar             |
|    8 | Login           | Password            | Test1234                                    | SalahPassword / (kosong)                | Harus cocok dengan akun     |
|    9 | Checkout        | Alamat Pengiriman   | Jl. Merdeka No.1, Jakarta Pusat 10110       | Jl. A / (kosong)                        | Minimal 10 karakter, wajib  |
|   10 | Checkout        | Metode Pembayaran   | transfer_bank / cod / e_wallet              | (tidak dipilih)                         | Wajib dipilih salah satu    |
|   11 | Checkout        | Catatan             | Tolong packing rapi, bubble wrap            | (kosong)                                | Opsional                    |
|   12 | Checkout        | Cart Data           | JSON array berisi product_id, jumlah, harga | [] (kosong) / invalid JSON              | Harus berisi minimal 1 item |

### Data Produk

|   ID | Nama Produk             |   Harga (Rp) |   Stok | Kategori   |
|-----:|:------------------------|-------------:|-------:|:-----------|
|    1 | Laptop Gaming Pro       |     15500000 |     25 | Elektronik |
|    2 | Headphone Wireless X    |      1250000 |     50 | Aksesoris  |
|    3 | Smartwatch Ultra        |      3750000 |     30 | Elektronik |
|    4 | Keyboard Mechanical RGB |       950000 |     40 | Aksesoris  |
|    5 | Mouse Gaming Precision  |       850000 |     60 | Aksesoris  |
|    6 | Monitor 4K UltraWide    |      8500000 |     15 | Elektronik |

### Akun Test

|   No | Nama Lengkap         | Email                         | Password   | No Telepon   | Alamat                          | Keterangan                                                        |
|-----:|:---------------------|:------------------------------|:-----------|:-------------|:--------------------------------|:------------------------------------------------------------------|
|    1 | Budi Santoso         | budi@test.com                 | Test1234   | 081234567890 | Jl. Merdeka No.1, Jakarta Pusat | Akun utama untuk testing login, checkout, riwayat                 |
|    2 | Admin SQA            | admin@sqashop.com             | Admin123   | -            | -                               | Akun admin untuk mengelola produk dan pesanan                     |
|    3 | User Baru (Register) | testuser_[timestamp]@test.com | Test1234   | (kosong)     | (kosong)                        | Dibuat otomatis saat TC-REG-001 & TC-REG-010 dijalankan           |
|    4 | User Riwayat Kosong  | newuser_[timestamp]@test.com  | Test1234   | (kosong)     | (kosong)                        | Dibuat otomatis saat TC-RIW-002 dijalankan, belum pernah checkout |

