package com.androidapps.islamiapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidapps.islamiapp.Constants
import com.androidapps.islamiapp.adapters.ChapterNamesAdapter
import com.androidapps.islamiapp.databinding.FragmentQuranBinding

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
        binding.idChaptersRecyclerView.adapter = adapter
    }
}
