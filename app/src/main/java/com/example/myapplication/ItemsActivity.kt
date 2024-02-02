package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList = findViewById<RecyclerView>(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa", "диван", "soft sofa", "sofa for the living room", 500))
        items.add(Item(2, "light", "свет", "light for ceiling", "light for ceiling in the living room", 800))
        items.add(Item(3, "kitchen", "кухня", "a place for eating", "a place where a meal is prepared", 600))

       itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}