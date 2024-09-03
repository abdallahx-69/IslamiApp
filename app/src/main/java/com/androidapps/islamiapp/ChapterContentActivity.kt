package com.androidapps.islamiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.adapters.ChaptersContentAdapter

class ChapterContentActivity : AppCompatActivity() {
    private var chapterName: String? = null
    private var chapterNumber: Int? = null
    private var chapterPosition: Int? = null
    private lateinit var chapterContentRecyclerView: RecyclerView
    private lateinit var adapter: ChaptersContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chapter_content)
        initParams()
        initViews()
    }

    private fun initViews() {
        chapterContentRecyclerView = findViewById(R.id.id_contentRecyclerView)
        readChapterFromFile(chapterPosition)
    }

    private fun initParams() {
        chapterName = intent.getStringExtra(Constants.CHAPTER_NAME_EXTRA)
        chapterNumber = intent.getIntExtra(Constants.CHAPTER_NUMBER_EXTRA, -1)
        chapterPosition = intent.getIntExtra(Constants.CHAPTER_POSITION_EXTRA, -1)
    }

    private fun readChapterFromFile(chapterPosition: Int?) {
        chapterPosition?.let {
            val allFileContent = assets.open("$chapterPosition.txt").bufferedReader().use {
                it.readText()
            }
            val list = allFileContent.split("\n")
            adapter = ChaptersContentAdapter(list)
            chapterContentRecyclerView.adapter = adapter
        }
    }
}
