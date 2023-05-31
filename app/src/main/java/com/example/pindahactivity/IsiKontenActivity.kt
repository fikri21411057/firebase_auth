package com.example.pindahactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

class IsiKontenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_konten)

        val Senjata = intent.getParcelableExtra<Senjata>("Senjata")
        if (Senjata != null) {
            val imageView: ImageView = findViewById(R.id.gambarSenjata)
            val textViewTitle: TextView = findViewById(R.id.namaSenjata)
            val textViewDesc: TextView = findViewById(R.id.deskripsiSenjata)

            imageView.setImageResource(Senjata.imageSource)
            textViewTitle.text = Senjata.imageTitle
            textViewDesc.text = Senjata.imageDecs
        }
    }
}