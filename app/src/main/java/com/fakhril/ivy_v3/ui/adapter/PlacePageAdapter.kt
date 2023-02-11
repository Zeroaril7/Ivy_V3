package com.fakhril.ivy_v3.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fakhril.ivy_v3.R
import com.fakhril.ivy_v3.domain.model.Place

class PlacePageAdapter(val context: Context) : RecyclerView.Adapter< PlacePageAdapter.ViewHolder>() {

    var placeClickListener: PlaceClickListener? = null
    private val allPlace = ArrayList<Place>()

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val card = itemView.findViewById<RelativeLayout>(R.id.rv_place_card)
        val garis = itemView.findViewById<ImageView>(R.id.line_place)
        val placeName = itemView.findViewById<TextView>(R.id.place_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rv_place_page, parent, false)
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.placeName.setText(allPlace.get(position).placeName)

        if (position == allPlace.size - 1){
            holder.card.setBackgroundResource(R.drawable.card_item_bottom)
            holder.garis.visibility = View.GONE
        }

        holder.itemView.setOnClickListener{
            placeClickListener?.onPlaceClick(allPlace.get(position))
        }
    }

    override fun getItemCount(): Int = allPlace.size

    interface PlaceClickListener {
        fun onPlaceClick(place: Place)
    }
    fun updateList(newList: List<Place>) {

        allPlace.clear()

        allPlace.addAll(newList)

        notifyDataSetChanged()
    }
}