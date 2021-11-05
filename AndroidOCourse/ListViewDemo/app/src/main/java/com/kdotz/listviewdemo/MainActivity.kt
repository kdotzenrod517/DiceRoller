package com.kdotz.listviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myListView = findViewById<ListView>(R.id.myListView)
        val myFamily = listOf("Tom", "Lynda", "Jerry", "Vi", "Nick", "Drew")

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, myFamily)

        myListView.adapter = arrayAdapter

        myListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "My family: " + myFamily[position], Toast.LENGTH_SHORT).show()
        }
    }
}


