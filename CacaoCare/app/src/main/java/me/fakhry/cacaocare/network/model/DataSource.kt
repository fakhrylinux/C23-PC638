package me.fakhry.cacaocare.network.model

object DataSource {
    val detections = listOf(
        Detection(
            id = 1,
            image = "https://storage.googleapis.com/cacaobucket/black_pod_rot/black_pod_rot_247.jpg",
            title = "Black Pod Rot (Fito)",
            symptom = "- Penyakit busuk buah kakao/Black pod rot ( Phytophthora palmivora) diawali dengan munculnya bercak kecil pada buah, sekitar dua hari setelah infeksi. \n" +
                    "- Bercak berwarna coklat, kemudian berubah menjadi kehitaman dan meluas dengan cepat sampai seluruh buah tertutup.\n",
            treatment = "Sejauh ini buah yang terlanjur busuk tidak dapat dipulihkan kembali. Sehingga yang dapat dilakukan yaitu dengan pembuangan buah yang terinfeksi supaya tidak menginfeksi tanaman yang lain. karena satu polong yang terinfeksi berpotensi melepaskan 4 juta sporangia.\n",
            prevention = "- Pengaturan pohon pelindung dan pemangkasan tanaman kakao agar terjadi keseimbangan cahaya dan suhu udara di dalam kebun. Memetik semua buah busuk, mengumpulkan dan membenamkannya di dalam tanah dengan luas sesuai kebutuhan per volume buah yang terkumpul dan ditaburi Trichoderma sp., kemudian ditutup dengan tanah setebal 30 cm. Bila ingin dimanfaatkan sebagai pupuk organik dapat ditaburi dengan EM4 atau pupuk kandang\n" +
                    "- Sebagai tindakan preventif dapat menyemprotkan jamur Trichoderma sp. per pohon dengan dosis 200 g/lt air.\n" +
                    "- Penggunaan bibit unggul (contoh : ICCRI 03, ICCRI 04)\n" +
                    "- Secara kimiawi, melindungi buah sehat dengan aplikasi fungisida berbahan aktif tembaga (Cu), dengan dosis 0,15-2 g Cu/pohon aplikasi 1-2 minggu sekali.\n" +
                    "- Pengendaliannya dengan sanitasi yakni bibit terserang diambil dan bibit yang sehat dilindungi dengan aplikasi fungisida Cu\n"
        ),
        Detection(
            id = 2,
            image = "https://storage.googleapis.com/cacaobucket/monilia/Monilia101.jpg",
            title = "Frosty Pod (Monilia)",
            symptom = "Pod atau polong (struktur pelindung yang berisi biji kakao) kurus\n" +
                    "* Pematangan polong yang terlalu dini (normalnya sekitar lima sampai enam bulan)\n" +
                    "* Bercak coklat tua atau bintik-bintik dengan batas tidak merata di atas polong\n" +
                    "* Pertumbuhan jamur putih di bagian luar polong\n",
            treatment = "Semprot tanaman sebulan sekali selama dua bulan dengan 1% tembaga hidroksida (merek yang direkomendasikan adalah Champion, Kocide, Champs dan Sulcox)\n" +
                    "•        Buang semua buah yang terinfeksi dari pohon kakao\n" +
                    "•        Polong yang terinfeksi harus dibuang saat masih ada embun pada polong. Polong lainnya dapat diambil dari pohon kapan saja sepanjang hari\n" +
                    "•        Polong harus dikumpulkan dalam kantong ganda, berjajar atau bertautan dan ditempatkan di bawah sinar matahari langsung selama dua minggu untuk membunuh spora aktif. Setelah waktu ini mereka dapat dibuang\n" +
                    "•        Polong juga dapat ditempatkan dalam kantong dan dikuburkan 18 inci di bawah tanah, setelah itu dilakukan kompos dengan menggunakan polong yang sudah ditanam\n" +
                    "•        Pohon yang terinfeksi harus dipangkas secara teratur\n",
            prevention = "Patuhi pedoman yang diberikan oleh pihak berwenang\n" +
                    "•        Desinfeksi pakaian dan sepatu jika Anda bersentuhan dengan area yang terkontaminasi\n" +
                    "•        Jangan pindahkan bibit, tanaman, atau buah apa pun dari area yang terkontaminasi\n" +
                    "*        Pangkas tanaman secara teratur untuk meminimalkan kelembaban dan meningkatkan ventilasi\n" +
                    "•        Pemeliharaan sistem drainase\n"
        ),
        Detection(
            id = 3,
            image = "https://storage.googleapis.com/cacaobucket/healthy/healthy_22.jpg",
            title = "Healthy",
            symptom = "Buah kakao dalam keadaan sehat. Pertahankan metode yang telah dilakukan supaya buah kakao selalu sehat.\n",
            treatment = "",
            prevention = ""
        ),
    )
}