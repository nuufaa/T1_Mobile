//Fitri Nufa Dastana
//F1D02310052
//Kelas B

fun main(){
    println("======== SISTEM PENILAIAN ========")

    print("Masukkan Nama Mahasiswa: ")
    val nama = readLine()

    print("Masukkan Nilai UTS (0-100): ")
    val uts = readLine()!!.toInt()

    print("Masukkan Nilai UAS (0-100): ")
    val uas = readLine()!!.toInt()

    print("Masukkan Nilai Tugas (0-100): ")
    val tugas = readLine()!!.toInt()

    //Menghitung nilai akhir
    val nilaiAkhir = (uts * 0.3) + (uas * 0.4) + (tugas * 0.3)

    //Menentukan grade menggunakan when
    val grade = when (nilaiAkhir.toInt()){
        in 85..100 -> "A"
        in 70..84 -> "B"
        in 60..69 -> "C"
        in 50..59 -> "D"
        else  -> "E"
    }

    //Menentukan keterangan grade
    val keterangan = when (grade){
        "A" -> "Sangat Baik"
        "B" -> "Baik"
        "C" -> "Cukup"
        "D" -> "Kurang"
        else -> "Sangat Kurang"
    }

    //Menentukan status lulus atau tidak
    val status = if (nilaiAkhir >= 60) "LULUS" else "TIDAK LULUS"

    println()
    println ("======== HASIL PENILAIAN ========")
    println("Nama         : $nama")
    println("Nilai UTS    : $uts (Bobot 30%)")
    println("Nilai UAS    : $uas (Bobot 40%)")
    println("Nilai Tugas  : $tugas (Bobot 30%)")
    println("--------------------------------")
    println("Nilai Akhir  : $nilaiAkhir")
    println("Grade        : $grade")
    println("Keterangan   : $keterangan")
    println("Status       : $status")
    println()

    if (status == "LULUS"){
        println("Selamat! Anda dinyatakan LULUS")
    } else {
        println("Maaf, Anda dinyatakan TIDAK LULUS")
    }
}