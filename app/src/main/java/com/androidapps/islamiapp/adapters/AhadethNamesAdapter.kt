package com.androidapps.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.databinding.ItemAhadethBinding
import com.androidapps.islamiapp.listeners.OnAhadethClickListener


class AhadethNamesAdapter(private val ahadethList: List<Ahadeth>) :
    RecyclerView.Adapter<AhadethNamesAdapter.AhadethViewHolder>() {

    var onAhadethClickListener: OnAhadethClickListener? = null

    class AhadethViewHolder(val binding: ItemAhadethBinding) : RecyclerView.ViewHolder(binding.root)

    data class Ahadeth(
        val title: String,
        val content: String
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethViewHolder {
        val binding = ItemAhadethBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AhadethViewHolder(binding)
    }

    override fun getItemCount(): Int = ahadethList.size

    override fun onBindViewHolder(holder: AhadethViewHolder, position: Int) {
        val item = ahadethList[position]
        holder.binding.ahadethNameText.text = item.title
        holder.itemView.setOnClickListener {
            onAhadethClickListener?.onAhadethClick(item, position)
        }
    }
}
