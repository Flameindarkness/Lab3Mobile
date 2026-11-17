package com.example.lab3mobile.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab3mobile.R
import com.example.lab3mobile.data.Tip

/**
 * Адаптер списка советов
 * @param tips Список советов
 * @param onTipClick Вызывается при нажатии на совет
 */
class TipsAdapter(
    private val tips: List<Tip>,
    private val onTipClick: (Tip) -> Unit
) : RecyclerView.Adapter<TipViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return TipViewHolder(view)
    }

    override fun onBindViewHolder(holder: TipViewHolder, position: Int) {
        val tip = tips[position]
        val context = holder.itemView.context

        holder.image.setImageResource(tip.imageRes)
        holder.day.text = context.getString(R.string.tip_day, tip.day)
        holder.title.setText(tip.titleRes)
        holder.shortDescription.setText(tip.shortDescriptionRes)
        holder.itemView.setOnClickListener { onTipClick(tip) }
    }

    override fun getItemCount(): Int = tips.size
}
