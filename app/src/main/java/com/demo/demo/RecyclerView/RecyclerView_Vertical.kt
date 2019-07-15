package com.demo.demo.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.demo.R
import com.demo.demo.model.Model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*

class RecyclerView_Vertical(val list: List<Model>, val context: Context):RecyclerView.Adapter<RecyclerView_Vertical.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val model=list[position]

        holder.view.txt_title_vertical.text=model.title
        holder.view.txt_subTitle_vertical.text=model.subTitle
        holder.view.txt_min.text=model.delivery +"-"+model.preparation+" min"

        Picasso.get().load(model.image).into(holder.view.img_vertical)

        holder.view.ratingBar.rating=model.rate!!.toFloat()
        holder.view.txt_price_vertical.text="$"+model.price




    }

    class ItemHolder(val view:View):RecyclerView.ViewHolder(view)
}