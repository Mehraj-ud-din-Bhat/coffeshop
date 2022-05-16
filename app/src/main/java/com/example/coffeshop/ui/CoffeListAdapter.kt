package com.example.coffeshop.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeshop.R

class CoffeListAdapter() : RecyclerView.Adapter<CoffeListAdapter.CoffeeViewHolder>() {

     lateinit var coffeeList:ArrayList<Coffee>
     lateinit var  context: Context


     constructor(List:ArrayList<Coffee>, mainActivity: Context) : this() {
         this.coffeeList=List
         this.context=mainActivity;

     }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_coffee,parent ,false)
        return  CoffeeViewHolder(view);
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
          // holder.phone.setText(studentList.get(position).studentPhone)
        holder.coffeeInfo.setText(coffeeList.get(position).coffeeInfo)
        holder.coffeeImage.setImageDrawable(coffeeList.get(position).coffeeImage)

    }

    override fun getItemCount(): Int {
      return this.coffeeList.size
    }


    class  CoffeeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       var coffeeInfo:TextView=   itemView.findViewById(R.id.coffeeInfo)
        var coffeeImage:ImageView=itemView.findViewById(R.id.coffeeImage)
    }
}




