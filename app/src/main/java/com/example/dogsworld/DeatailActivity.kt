package com.example.dogsworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DeatailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deatail)

        val getData = intent.getParcelableExtra<Dogs>("android")
        if (getData != null){
            val detailTitle: TextView = findViewById(R.id.title)
            val detailDesc: TextView = findViewById(R.id.detailDesc)
            val detailImage: ImageView = findViewById(R.id.detailImage)

            detailTitle.text = getData.name
            detailDesc.text = getData.desc
            detailImage.setImageResource(getData.detailImage)
        }
    }
}
