package com.example.affirmationslist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmationslist.adapter.ItemAdapter
import com.example.affirmationslist.data.Datasource

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize data.
        val myDataset = Datasource().loadAffirmations()

        // RecyclerView to display data
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        // Display data to RecyclerView using an adapter
        // Adapter acts as bridge between a data (Datasource) and a view (RecyclerView)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }
}