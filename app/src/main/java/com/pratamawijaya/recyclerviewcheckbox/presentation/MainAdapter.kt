package com.pratamawijaya.recyclerviewcheckbox.presentation

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import com.pratamawijaya.recyclerviewcheckbox.R
import com.pratamawijaya.recyclerviewcheckbox.model.Food

/**
 * Created by pratama on 8/29/17.
 */
class MainAdapter(val context: Context, val foods: List<Food>) : RecyclerView.Adapter<MainAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(context).inflate(R.layout.item_food, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {

        holder.cbFood.tag = position
        // check state object, n then change state checkbox
        holder.cbFood.isChecked = foods[position].isSelected

        // set listener for checkbox
        holder.cbFood.setOnClickListener {
            val pos = holder.cbFood.tag as Int
            foods[pos].isSelected = !foods[pos].isSelected
        }

        // bind item to holder
        holder.bindItem(foods[position])
    }

    fun getItem() = foods

    override fun getItemCount(): Int = foods.size

    class MainHolder(view: View) : RecyclerView.ViewHolder(view) {

        var tvName: TextView = view.findViewById(R.id.tvFoodName)
        var cbFood: CheckBox = view.findViewById(R.id.cbFood)

        fun bindItem(food: Food) {
            tvName.text = food.name
        }

    }
}