package com.example.lab3mobile.ui

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.R

/**
 * Хранит ссылки на View элемента списка. findViewById вызывается один раз — при создании
 */
class TipViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val image: ImageView = itemView.findViewById(R.id.tip_image)
    val day: TextView = itemView.findViewById(R.id.tip_day)
    val title: TextView = itemView.findViewById(R.id.tip_title)
    val shortDescription: TextView = itemView.findViewById(R.id.tip_short_description)
}
