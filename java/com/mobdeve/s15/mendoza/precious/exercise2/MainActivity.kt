package com.mobdeve.s15.mendoza.precious.exercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewFeed: RecyclerView
    private lateinit var postAdapter: PostAdapter
    private lateinit var postList: ArrayList<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize Data using the correct method name from DataHelper
        postList = DataHelper.initializeData()

        // Initialize RecyclerView from activity_main.xml
        recyclerViewFeed = findViewById(R.id.recyclerViewFeed)

        // Use a LinearLayoutManager to enable vertical scrolling
        recyclerViewFeed.layoutManager = LinearLayoutManager(this)

        // Initialize and set Adapter with the post list
        postAdapter = PostAdapter(postList)
        recyclerViewFeed.adapter = postAdapter
    }
}