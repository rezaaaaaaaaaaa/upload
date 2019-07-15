package com.demo.demo.RecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.demo.R
import com.demo.demo.model.Model
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_horizantal.view.*

class RecyclerView_Horizantal(val list: List<Model>,val context: Context):RecyclerView.Adapter<RecyclerView_Horizantal.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_horizantal,parent,false)
        return ItemHolder(view)
    }

    override fun getItemCount(): Int {

        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val model=list[position]

        holder.view.txt_title.text=model.title
        holder.view.txt_subtitle.text=model.subTitle
        holder.view.txt_time.text=model.delivery +"-"+model.preparation+" min"

        Picasso.get().load(model.image).into(holder.view.img)

        holder.view.ratingBar.rating=model.rate!!.toFloat()
        holder.view.txt_price.text="$"+model.price




    }

    class ItemHolder(val view:View):RecyclerView.ViewHolder(view)
}