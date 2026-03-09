//Fitri Nufa Dastana
//F1D02310052
//Kelas B

//Data class untuk menyimpan data mahasiswa
data class NilaiMahasiswa(
    val nim: String,
    val nama: String,
    val mataKuliah: String,
    val nilai: Int
)

//Fungsi untuk menentukan grade
fun getGrade(nilai: Int): String{
    return when(nilai){
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else -> "E"
    }
}

fun main(){
    val mahasiswa = listOf(
        NilaiMahasiswa("F1D02310052", "Fitri Nufa Dastana", "Pemrograman Bergerak", 90),
        NilaiMahasiswa("F1D02310098", "Yusri Abdi", "Pemrograman Bergerak", 85),
        NilaiMahasiswa("F1D02310114", "Izzat Nazhiefa", "Pemrograman Bergerak", 70),
        NilaiMahasiswa("F1D02310048", "Fadila Rahmania", "Pemrograman Bergerak", 68),
        NilaiMahasiswa("F1D02310123", "M.Wahyu Hilal Abroor", "Pemrograman Bergerak", 76),
        NilaiMahasiswa("F1D02310042", "Baiq Alfia Zahira", "Pemrograman Bergerak", 59),
        NilaiMahasiswa("F1D02310062", "Julia Ariani", "Pemrograman Bergerak", 64),
        NilaiMahasiswa("F1D02310108", "Nurmiftah Aziz", "Pemrograman Bergerak", 88),
        NilaiMahasiswa("F1D02310140", "Nur Adinda Juniarti", "Pemrograman Bergerak", 55),
        NilaiMahasiswa("F1D02310009", "Muhammad  Andika Azkiya", "Pemrograman Bergerak", 60)
    )

    println("======== DATA NILAI MAHASISWA ========")
    println()
    println(String.format("%-3s %-12s %-25s %-22s %-5s", "No", "NIM", "Nama", "MataKuliah", "Nilai"))
    var no = 1
    for (mhs in mahasiswa){
        println(String.format(
            "%-3s %-12s %-25s %-22s %-5s", 
            no++, 
            mhs.nim, 
            mhs.nama, 
            mhs.mataKuliah, 
            mhs.nilai
        ))
    }

    //Filter mahasiswa yang lulus (nilai >= 70)
    val lulus = mahasiswa.filter { it.nilai >= 70 }

    //Filter mahasiswa yang tidak lulus (nilai < 70)
    val tidakLulus = mahasiswa.filter { it.nilai < 70 }

    //Hitung rata-rata nilai
    val rataRata = mahasiswa.map { it.nilai }.average()

    //Nilai tertinggi
    val tertinggi = mahasiswa.maxByOrNull { it.nilai }

    //Nilai terendah
    val terendah = mahasiswa.minByOrNull { it.nilai }

    println()
    println("======== STATISTIK =========")
    println("Total Mahasiswa  : ${mahasiswa.size}")
    println("Rata-rata Nilai  : $rataRata") 
    println("Nilai Tertinggi  : ${tertinggi?.nilai} (${tertinggi?.nama})")
    println("Nilai Terendah   : ${terendah?.nilai} (${terendah?.nama})")

    println()
    println("======== MAHASISWA LULUS ========")
    var noLulus = 1
    for (mhs in lulus){
        println("${noLulus++} ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }

    println()
    println("======== MAHASISWA TIDAK LULUS ========")
    var noTidakLulus = 1
    for (mhs in tidakLulus){
        println("${noTidakLulus++} ${mhs.nama} - ${mhs.nilai} (${getGrade(mhs.nilai)})")
    }
    
    //Urut Ascending
    val ascending = mahasiswa.sortedBy { it.nilai }
    println()
    println("======== URUTAN NILAI ASCENDING ========")
    println(String.format("%-25s %-7s %-5s", "Nama", "Nilai", "Grade"))
    for (mhs in ascending){
        println(
            String.format("%-25s %-7s %-5s", 
            mhs.nama, 
            mhs.nilai, 
            getGrade(mhs.nilai)
        ))
    }

    //Urut Descending
    val descending = mahasiswa.sortedByDescending { it.nilai }
    println()
    println("======== URUTAN NILAI DESCENDING ========")
    println(String.format("%-25s %-7s %-5s", "Nama", "Nilai", "Grade"))
    for (mhs in descending){
        println(
            String.format("%-25s %-7s %-5s", 
            mhs.nama, 
            mhs.nilai, 
            getGrade(mhs.nilai)
        ))
    }

    //Kelompok berdasarkan grade
    val kelompokGrade = mahasiswa.groupBy { getGrade(it.nilai) }
    println()
    println("======== KELOMPOK MAHASISWA BERDASARKAN GRADE ========")
    for ((grade, mhsList) in kelompokGrade) {
        println("Grade $grade:")
        for (mhs in mhsList){
            println(" - ${mhs.nama} (${mhs.nilai})")
        }
    }

    //Jumlah berdasarkan grade
    // val totalGrade = mahasiswa.groupBy { getGrade(it.nilai) }
    println()
    println("======== JUMLAH PER GRADE ========")
    for ((grade, mhsList) in kelompokGrade) {
        println("Grade $grade: ${mhsList.size} mahasiswa")
    }

    //Cari mahasiswa berdasarkan nama
    println()
    print("Masukkan nama mahasiswa yang ingin dicari: ")
    val namaCari = readLine()
    val hasilCari = mahasiswa.filter { 
        it.nama.contains(namaCari ?: "", ignoreCase = true) }
    println()
    println("======== HASIL PENCARIAN ========")
    for (mhs in hasilCari){
        println(" - ${mhs.nama} (${mhs.nilai})")
    }
}