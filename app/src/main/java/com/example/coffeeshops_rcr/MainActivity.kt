package com.example.coffeeshops_rcr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: ArrayList<Item>
    lateinit var adapter: adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)

        recyclerView.layoutManager =
            GridLayoutManager(this, 1)

        items = (lista())
        adapter = adapter(items, this)
        recyclerView.setItemViewCacheSize(items.size)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    fun lista()
            : ArrayList<Item> {
        return arrayListOf(
            Item(R.drawable.images, "Antico Caffe Greco", "St. Italy, Rome", 0f),
            Item(R.drawable.images1, "Coffee Room", "St. Germany, Berlin", 0f),
            Item(R.drawable.images2, "Coffee Ibiza", "St. Colon, Madrid", 0f),
            Item(R.drawable.images3, "Pudding Coffee Shop", "St. Diagonal, Barcelona", 0f),
            Item(R.drawable.images4, "L' Express", "St. Picadilly Circus, London", 0f),
            Item(R.drawable.images5, "Coffee Corner", "St. Angel Guimera, Valencia", 0f),
            Item(R.drawable.images6, "Sweet Cup", "St. Kinkerstraat, Amsterdam", 0f),
        )
    }
}