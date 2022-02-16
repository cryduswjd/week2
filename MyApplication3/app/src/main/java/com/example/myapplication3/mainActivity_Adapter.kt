package com.example.myapplication3

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.view.*

class mainActivity_Adapter(var context: Context,val imgRes: IntArray, val data1: Array<String>, val textView: TextView): RecyclerView.Adapter<mainActivity_Adapter.ViewHolderClass>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {

            val itemView = LayoutInflater.from(context).inflate(R.layout.row, null)
            val holder = ViewHolderClass(itemView)
            itemView.setOnClickListener(holder)

            return holder
        }

        override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
            holder.rowImageView.setImageResource(imgRes[position])
            holder.rowTextView.text = data1[position]
        }

        override fun getItemCount(): Int {
            return imgRes.size
        }

        inner class ViewHolderClass(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

            val rowImageView = itemView.rowImageView
            val rowTextView = itemView.rowTextView

            override fun onClick(p0: View?) {
                textView.text = data1[adapterPosition]
                Log.e("test",adapterPosition.toString())
            }
        }
}