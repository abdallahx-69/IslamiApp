package com.androidapps.islamiapp.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidapps.islamiapp.adapters.ChapterNamesAdapter
import com.androidapps.islamiapp.databinding.FragmentQuranBinding
import com.androidapps.islamiapp.listeners.OnChapterClickListener
import com.androidapps.islamiapp.utils.Constants

class QuranFragment : Fragment() {
    private lateinit var binding: FragmentQuranBinding
    private lateinit var adapter: ChapterNamesAdapter
    private lateinit var chaptersList: List<Pair<String, Int>>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chaptersList = Constants.chapters
        adapter = ChapterNamesAdapter(chaptersList)
        adapter.onChapterClickListener = object : OnChapterClickListener {
            override fun onChapterClick(chapters: Pair<String, Int>, position: Int) {
                val intent = Intent(requireActivity(), ChapterContentActivity::class.java)
                intent.putExtra(Constants.CHAPTER_NAME_EXTRA, chapters.first)
                intent.putExtra(Constants.CHAPTER_NUMBER_EXTRA, chapters.second)
                intent.putExtra(Constants.CHAPTER_POSITION_EXTRA, position + 1)
                startActivity(intent)
            }
        }
        binding.idChaptersRecyclerView.adapter = adapter
    }
}
