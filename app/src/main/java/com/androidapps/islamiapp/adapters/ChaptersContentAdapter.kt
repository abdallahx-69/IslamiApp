package com.androidapps.islamiapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.androidapps.islamiapp.R

class ChaptersContentAdapter(private val chapterContentList: List<String>) :
    RecyclerView.Adapter<ChaptersContentAdapter.ChapterContentViewHolder>() {
    class ChapterContentViewHolder(private val itemChapterContent: View) :
        ViewHolder(itemChapterContent) {
        val chapter: TextView = itemChapterContent.findViewById(R.id.id_chapterContent)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChapterContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_shapter_content, parent, false)
        return ChapterContentViewHolder(view)
    }

    override fun getItemCount(): Int = chapterContentList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ChaptersContentAdapter.ChapterContentViewHolder,
        position: Int
    ) {
        val item = chapterContentList[position]
        holder.chapter.text = "$item(${position + 1})"
    }
}