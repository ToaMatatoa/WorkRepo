package com.example.myapplicationds.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationds.R
import com.example.myapplicationds.data.local.model.LocalData
import com.example.myapplicationds.data.remote.model.ResponseData
import kotlinx.android.synthetic.main.rv_item.view.*

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private val items = mutableListOf<ResponseData>()

    fun addItemsRemote(listOfItems: List<ResponseData>) {
        items.addAll(listOfItems)
        notifyDataSetChanged()
    }
//    fun addItemsLocale(listOfLocalItems: List<LocalData>) {
//        items.addAll(listOfLocalItems)
//        notifyDataSetChanged()
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        View.inflate(parent.context, R.layout.rv_item, null)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ResponseData) =
            with(itemView) {

                tv_title.text = item.title
            }
    }
}
