package com.hanseltritama.rickandmortyapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hanseltritama.rickandmortyapp.R
import com.hanseltritama.rickandmortyapp.data.Result

class MyAdapter(context: Context) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var items = ArrayList<Result>()
    var mContext = context

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageThumb: ImageView = itemView.findViewById(R.id.image_view_cardview)
        private val title: TextView = itemView.findViewById(R.id.text_view_cardview)

        fun bind(mContext: Context, data: Result) {
            title.text = data.name

            Glide.with(mContext)
                .load(data.image)
                .into(imageThumb)
        }
    }

    fun updateData(items: ArrayList<Result>) {
        this.items = items
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(mContext, items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}