package com.example.dogsworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var doglist : ArrayList<Dogs>
    lateinit var imagelist : Array<Int>
    lateinit var namelist : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagelist = arrayOf(
            R.drawable.labrador_retriever,
            R.drawable.boxer,
            R.drawable.beagle,
            R.drawable.bulldog,
            R.drawable.poodle,
            R.drawable.german_shepherd,
            R.drawable.golden_retriever,
            R.drawable.rottweiler,
            R.drawable.yorkshire_terrier
        )

        namelist = arrayOf(
            "LABRADOR RETRIEVER",
            "BOXER",
            "BEAGLE",
            "BULL DOG",
            "POODLE",
            "GERMAN SHEPHERD",
            "GOLDEN RETRIEVER",
            "ROTTWEILER",
            "YORKSHIRE TERRIER"
        )

        recyclerView = findViewById(R.id.rvcycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        doglist = ArrayList()
        getData()
    }

    private fun getData() {
        for (i in imagelist.indices) {
            val dataclass = Dogs(imagelist[i], namelist[i])
            doglist.add(dataclass)
        }
        Log.d("DogListSize", "Size of doglist: ${doglist.size}")
        Log.d("DogListContent", "Content of doglist: $doglist")
        recyclerView.adapter = DogsAdapter(doglist)
    }
}
