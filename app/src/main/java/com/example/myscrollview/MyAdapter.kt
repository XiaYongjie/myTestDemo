package com.example.myscrollview

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_item_layout.view.*

class MyAdapter(var context: Context,var data:MutableList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(context).inflate(R.layout.view_item_layout,p0,false))
    }

    override fun getItemCount() =data.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.itemView.tv.text ="position $p1"

        when(p1%5){
            0-> {
                p0.itemView.tv.setBackgroundColor(Color.GREEN)
            }
            1-> {
                p0.itemView.tv.setBackgroundColor(Color.YELLOW)
            }
            2-> {
                p0.itemView.tv.setBackgroundColor(Color.RED)
            }
            3-> {
                p0.itemView.tv.setBackgroundColor(Color.BLUE)
            }
            4-> {
                p0.itemView.tv.setBackgroundColor(Color.WHITE)
            }
        }
    }
}