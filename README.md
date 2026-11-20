# AM Calculator — Cathay Pacific Asia Miles Calculator (Android)

Aplikasi Android native berbasis **Kotlin & Jetpack Compose (Material 3)** untuk menghitung kebutuhan **Asia Miles** pada seluruh rute jaringan **Cathay Pacific**, lengkap dengan informasi armada pesawat, ketersediaan kabin (**Economy, Premium Economy, Business, First Class Suite, Aria Suite**), serta jadwal keberangkatan dan ketibaan.

## Fitur Utama

1. **Kalkulator Asia Miles (1 Leg & Multi-Leg hingga 4 Leg)**
   - Mendukung **Sekali Jalan (One-Way)** dan **Pulang-Pergi (Round-Trip)**.
   - 5 pilihan kelas kabin: **Economy**, **Premium Economy**, **Business**, **First Class (First Suite)**, dan **Suite (Aria Suite)**.
   - Otomatis menghitung dan membandingkan **1 PNR (Jarak Gabungan)** vs **PNR Terpisah (Per-Leg)** beserta selisih penghematan miles.
   - Fitur **Auto-Transit HKG** untuk menyusun rute sambungan dari kota mana saja via Hub Hong Kong (HKG).
   - Validasi otomatis ketersediaan kabin pada tipe pesawat yang dipilih (misalnya notifikasi jika rute/armada belum memiliki First Class atau Aria Suite).

2. **Direktori Rute, Armada & Jadwal (80 Bandara · 82 Rute Dua Arah / 164 Arah)**
   - Mencakup seluruh wilayah operasional Cathay Pacific: **Indonesia (CGK, DPS, SUB)**, Asia Tenggara, Jepang & Korea, Tiongkok & Taiwan, Asia Selatan, Timur Tengah, Australia & Selandia Baru, Eropa, Amerika Utara, Afrika Selatan, serta rute **Fifth Freedom (TPE–NRT, TPE–KIX, TPE–NGO)**.
   - Menampilkan nomor penerbangan (`CX`), jam keberangkatan & ketibaan, durasi terbang, serta jenis pesawat (`A350-900`, `A350-1000`, `B777-300ER Aria Suite`, `B777-300ER 4-Class First Suite`, `A330-300`, `B777-300`, `A321neo`).
   - Pencarian instan berdasarkan kode IATA, kota, nomor penerbangan, tipe pesawat, atau kata kunci `Aria` / `First`.

3. **Tabel Award Chart & Panduan Armada**
   - Referensi lengkap Cathay Pacific Standard Award Chart (Ultra-Short hingga Ultra-Long) beserta penjelasan zona **Short-Haul Type 1 vs Type 2** dan detail konfigurasi armada.

## Cara Build APK via GitHub Actions (Tanpa Android Studio)

1. Ekstrak file ZIP ini dan unggah seluruh isinya ke repository GitHub baru.
2. Buka tab **Actions** di repository GitHub Anda.
3. Workflow **Build AM Calculator Debug APK** akan berjalan otomatis saat push (atau klik **Run workflow** secara manual).
4. Setelah status berubah hijau, klik workflow tersebut dan unduh file **`AM-Calculator-debug-apk`** di bagian **Artifacts**, lalu install `app-debug.apk` di perangkat Android Anda.

## Struktur Proyek

```text
├── .github/workflows/android-build.yml   # GitHub Actions cloud build & unit test
├── app/
│   ├── build.gradle.kts
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/com/amcalculator/app/
│       │   │   ├── MainActivity.kt
│       │   │   ├── data/
│       │   │   │   ├── Models.kt
│       │   │   │   └── CathayDataRepository.kt
│       │   │   ├── domain/
│       │   │   │   └── AwardCalculator.kt
│       │   │   └── ui/
│       │   │       ├── components/AirportPickerDialog.kt
│       │   │       ├── screens/CalculatorScreen.kt
│       │   │       ├── screens/RoutesDirectoryScreen.kt
│       │   │       ├── screens/AwardChartScreen.kt
│       │   │       └── theme/Theme.kt
│       │   └── res/
│       └── test/java/com/amcalculator/app/
│           └── AwardCalculatorTest.kt
├── build.gradle.kts
├── gradle.properties
└── settings.gradle.kts
```
