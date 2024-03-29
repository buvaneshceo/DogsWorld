package com.example.dogsworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var doglist : ArrayList<Dogs>
    private lateinit var myAdapter: DogsAdapter
    lateinit var desclist : Array<String>
    lateinit var detaillistImage : Array<Int>
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

        desclist = arrayOf(
            getString(R.string.Labrador_Retriever),
            getString(R.string.Boxer),
            getString(R.string.Beagle),
            getString(R.string.Bulldog),
            getString(R.string.Poodle),
            getString(R.string.German_Shepherd),
            getString(R.string.Golden_Retriever),
            getString(R.string.Rottweiler),
            getString(R.string.Yorkshire_Terrier)
        )

        detaillistImage = arrayOf(
            R.drawable.labrador_retriever1,
            R.drawable.boxer1,
            R.drawable.beagle1,
            R.drawable.bulldog1,
            R.drawable.poodle1,
            R.drawable.german_shepherd1,
            R.drawable.golden_retriever1,
            R.drawable.rottweiler1,
            R.drawable.yorkshire_terrier1
        )

        recyclerView = findViewById(R.id.rvcycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        doglist = ArrayList()
        getData()

        myAdapter.onItemClick = {
            val intent = Intent(this,DeatailActivity::class.java)
            intent.putExtra("android",it)
            startActivity(intent)
        }
    }

    private fun getData() {
        myAdapter = DogsAdapter(doglist)
        for (i in imagelist.indices) {
            val dataclass = Dogs(imagelist[i], namelist[i], desclist[i], detaillistImage[i])
            doglist.add(dataclass)
        }
        Log.d("DogListSize", "Size of doglist: ${doglist.size}")
        Log.d("DogListContent", "Content of doglist: $doglist")
        recyclerView.adapter = myAdapter
    }
}
