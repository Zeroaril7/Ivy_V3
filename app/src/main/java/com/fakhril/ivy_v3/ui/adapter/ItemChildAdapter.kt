package com.fakhril.ivy_v3.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.ivy_v3.R
import com.fakhril.ivy_v3.domain.model.Item


class ItemChildAdapter(private val allItem: ArrayList<Item>): RecyclerView.Adapter<ItemChildAdapter.ViewHolder>(){

    var itemClickListener: ItemChildAdapter.ItemClickListener? = null



    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val cardItem = itemView.findViewById<RelativeLayout>(R.id.rv_child_item)
        val garisItem = itemView.findViewById<ImageView>(R.id.line_item)
        val itemName = itemView.findViewById<TextView>(R.id.item_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.child_rv_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var itemList = allItem[position]
        holder.itemName.text = itemList.itemName

        if (position == allItem.size - 1){
            holder.cardItem.setBackgroundResource(R.drawable.card_item_bottom)
            holder.garisItem.visibility = View.GONE
        }

        holder.itemView.setOnClickListener{
            itemClickListener?.onItemClick(allItem.get(position))
        }
    }

    override fun getItemCount(): Int = allItem.size

    interface ItemClickListener {
        fun onItemClick(item: Item)
    }

    fun updateListItem(newList: List<Item>) {

        allItem.clear()

        allItem.addAll(newList)

        notifyDataSetChanged()
    }
}