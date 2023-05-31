package com.example.pindahactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KontenActivity : AppCompatActivity() {
    private lateinit var SenjataRecyclerView: RecyclerView
    private lateinit var SenjataList : ArrayList<Senjata>
    private lateinit var SenjataAdapter : SenjataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konten)

        SenjataList = ArrayList()

        SenjataList.add(
            Senjata(R.drawable.pistol, "PISTOL",
                "Pistol adalah senjata api yang bisa ditembakkan dengan satu tangan. Kata 'pistol' mulai digunakan untuk mendeskripsikan senjata api genggam pada abad ke-18. Pada abad ke-15 pistol berarti sebuah pisau kecil yang bisa disembunyikan di dalam pakaian. Pistol atau senjata api genggam dibagi menjadi dua jenis utama..")
        )

        SenjataList.add(
            Senjata(R.drawable.melee, "MELEE",
                "Seperti artinya, melee weapon adalah senjata jarak dekat yang bisa kamu gunakan untuk memukul atau bahkan membunuh lawanmu. Senjata ini sangat berguna pada saat kamu berada di situasi yang mengharuskanmu bertempur di jarak dekat.")
        )

        SenjataList.add(
            Senjata(R.drawable.rifle, "RIFLE",
                "Senapan (bahasa Inggris: Rifle) adalah senjata api laras panjang yang dirancang untuk menembak secara akurat, dengan laras yang memiliki pola heliks alur (rifling) yang memotong lubangnya.")
        )

        SenjataList.add(
            Senjata(R.drawable.shotgun, "SHOTGUN",
                "Senapan gentel, juga dikenal sebagai senapan gotri, senapan patah, atau senapan sebar (bahasa Inggris: Shotgun atau scattergun karena proyektil yang bersifat menyebar) adalah senjata api yang biasanya dirancang untuk ditembakkan dari bahu, yang menggunakan energi dari sebuah selongsong berbentuk silinder dan menembakkan sejumlah gentel bulat kecil / gotri (bola timah kecil), atau sebuah proyektil gotri padat.")
        )

        SenjataList.add(
            Senjata(R.drawable.ump, "SMG",
                "Ada tiga varian dari UMP ini yaitu UMP45 menggunakan peluru .45 ACP; UMP40, menggunakan peluru .40 S&W; dan UMP9 menggunakan peluru 9 x 19 mm Parabellum. Perbedaan lain selain dari tipe peluru yang dipakai adalah pada bentuk dari magazen yang digunakan, tipe UMP9 menggunakan magazen dengan bentuk melengkung, sedangkan UMP40 dan UMP45 menggunakan magazen lurus. Ketiga jenis UMP ini dapat dimodifaksi agar dapat menggunakan ketiga jenis peluru diatas dengan cara mengganti bolt, barrel, dan tentu saja magazen..")
        )

        SenjataList.add(
            Senjata(R.drawable.sniper, "SNIPER",
                "Penembak runduk adalah seorang prajurit infanteri yang secara khusus terlatih untuk mempunyai kemampuan membidik, menembak, dan membunuh musuh secara tersembunyi dari jarak jauh dengan menggunakan senapan.")
        )


        SenjataRecyclerView = findViewById(R.id. SenjataRecyclerView)
        SenjataRecyclerView.setHasFixedSize(true)
        SenjataRecyclerView.layoutManager = LinearLayoutManager(this)

        SenjataAdapter =  SenjataAdapter(SenjataList)
        SenjataRecyclerView.adapter = SenjataAdapter
        SenjataAdapter.onItemClick = {
            val intent = Intent(this, IsiKontenActivity::class.java)
            intent.putExtra("Senjata", it)
            startActivity(intent)
        }
    }
}