package com.pratamawijaya.recyclerviewcheckbox.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Button
import com.pratamawijaya.recyclerviewcheckbox.R
import com.pratamawijaya.recyclerviewcheckbox.model.Food

class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var btnGetData: Button
    lateinit var adapter: MainAdapter
    var foods = mutableListOf<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)
        btnGetData = findViewById(R.id.btnGetData)

        for (i in 1..50) {
            val food = Food()
            food.id = i
            food.name = "Food $i"
            foods.add(food)
        }

        adapter = MainAdapter(this, foods)

        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = adapter


        btnGetData.setOnClickListener {
            val data = adapter.getItem()

            data.map {
                Log.d("tag", "data ${it.name} ${it.isSelected}")
            }
        }
    }
}
