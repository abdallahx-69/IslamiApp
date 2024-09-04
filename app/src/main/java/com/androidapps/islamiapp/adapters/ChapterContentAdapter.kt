package com.androidapps.islamiapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.databinding.ItemShapterContentBinding

class ChapterContentAdapter(private val chapterContentList: List<String>) :
    RecyclerView.Adapter<ChapterContentAdapter.ChapterContentViewHolder>() {

    class ChapterContentViewHolder(val binding: ItemShapterContentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChapterContentViewHolder {
        val binding =
            ItemShapterContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChapterContentViewHolder(binding)
    }

    override fun getItemCount(): Int = chapterContentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ChapterContentViewHolder, position: Int) {
        val item = chapterContentList[position]
        holder.binding.idChapterContent.text = "$item(${position + 1})"
    }
}