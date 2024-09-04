package com.androidapps.islamiapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.databinding.ItemAhadethContentBinding

class AhadathContentAdapter(private val ahadethContentList: List<String>) :
    RecyclerView.Adapter<AhadathContentAdapter.AhadethContentViewHolder>() {

    class AhadethContentViewHolder(val binding: ItemAhadethContentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AhadethContentViewHolder {
        val binding =
            ItemAhadethContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AhadethContentViewHolder(binding)
    }

    override fun getItemCount(): Int = ahadethContentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: AhadethContentViewHolder, position: Int) {
        val item = ahadethContentList[position]
        holder.binding.idChapterContent.text = "$item (${position + 1})"
    }
}