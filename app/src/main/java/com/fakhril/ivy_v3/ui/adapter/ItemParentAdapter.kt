package com.fakhril.ivy_v3.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.ivy_v3.R
import com.fakhril.ivy_v3.domain.model.Item
import com.fakhril.ivy_v3.domain.model.Place
import com.fakhril.ivy_v3.ui.viewmodel.MainViewModel

class ItemParentAdapter(private val allPlace: ArrayList<Place>): RecyclerView.Adapter<ItemParentAdapter.ViewHolder>() {

    private val allItem = ArrayList<Item>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val placeName = itemView.findViewById<TextView>(R.id.place_name_item)
        val ivyRV = itemView.findViewById<RecyclerView>(R.id.child_rv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.parent_rv_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val place = allPlace[position]

        holder.placeName.setText(allPlace.get(position).placeName)
        holder.ivyRV.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(holder.itemView.context)
                val adapter = ItemChildAdapter(place.itemData as ArrayList<Item>)
                holder.ivyRV.adapter = adapter

        }
    }

    override fun getItemCount(): Int = allPlace.size

    fun updateListPlace(newList: List<Place>) {

        allPlace.clear()

        allPlace.addAll(newList)

        notifyDataSetChanged()
    }


}