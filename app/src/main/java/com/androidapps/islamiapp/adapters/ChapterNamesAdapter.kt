package com.androidapps.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.databinding.ItemShapterBinding

class ChapterNamesAdapter(private val chaptersList: List<Pair<String, Int>>) :
    RecyclerView.Adapter<ChapterNamesAdapter.ChapterNameViewHolder>() {

    class ChapterNameViewHolder(val binding: ItemShapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterNameViewHolder {
        val binding = ItemShapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterNameViewHolder(binding)
    }

    override fun getItemCount(): Int = chaptersList.size

    override fun onBindViewHolder(holder: ChapterNameViewHolder, position: Int) {
        val (name, number) = chaptersList[position]
        holder.binding.chapterNameText.text = name
        holder.binding.chapterNumberText.text = number.toString()
    }
}
