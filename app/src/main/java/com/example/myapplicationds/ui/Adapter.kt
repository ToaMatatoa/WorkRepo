package com.example.myapplicationds.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationds.R
import com.example.myapplicationds.data.local.model.LocalData
import kotlinx.android.synthetic.main.rv_item.view.*

class Adapter(private val onItemClicked: () -> Unit) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    private val items = mutableListOf<LocalData>()

    fun addItems(listOfItems: List<LocalData>) {
        items.addAll(listOfItems)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        View.inflate(parent.context, R.layout.rv_item, null)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position]) { }
        with(holder.itemView) {
            setOnClickListener { onItemClicked.invoke() }
        }
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: LocalData, listener: () -> Unit) =
            with(itemView) {

                tv_title.text = item.title
                tv_body.text = item.body
                setOnClickListener { listener }
            }
    }
}

