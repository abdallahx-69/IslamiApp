package com.androidapps.islamiapp.fragments.ahadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.R
import com.androidapps.islamiapp.adapters.AhadethNamesAdapter
import com.androidapps.islamiapp.listeners.OnAhadethClickListener
import com.androidapps.islamiapp.utils.Constants

class AhadethFragment : Fragment() {
    private lateinit var ahadethRecyclerView: RecyclerView
    private lateinit var adapter: AhadethNamesAdapter
    private lateinit var titleList: MutableList<String>
    private lateinit var contentList: MutableList<String>
    private lateinit var ahadethList: MutableList<AhadethNamesAdapter.Ahadeth>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
    }

    fun initViews(view: View) {
        ahadethList = mutableListOf()
        ahadethRecyclerView = view.findViewById(R.id.id_ahadethRecyclerView)
        readAhadethFile()
    }

    private fun readAhadethFile() {
        val fileContent = requireContext().assets.open("AllAhadeth.txt").bufferedReader().use {
            it.readText()
        }
        val ahadethListSplit = fileContent.trim().split("#")
        titleList = mutableListOf()
        contentList = mutableListOf()
        ahadethListSplit.forEach { ahadeth ->
            val splittedAhadeth = ahadeth.trim().split("\n")
            val splittedContentList = splittedAhadeth.subList(1, splittedAhadeth.size)
            ahadethList.add(
                AhadethNamesAdapter.Ahadeth(
                    title = splittedAhadeth[0],
                    splittedContentList.joinToString()
                )
            )
        }
        adapter = AhadethNamesAdapter(ahadethList)
        adapter.onAhadethClickListener = object : OnAhadethClickListener {
            override fun onAhadethClick(ahadeth: AhadethNamesAdapter.Ahadeth, position: Int) {
                val intent = Intent(requireActivity(), AhadethContentActivity::class.java)
                intent.putExtra(Constants.HADETH_TITLE_EXTRA, ahadeth.title)
                intent.putExtra(Constants.HADETH_Content_EXTRA, ahadeth.content)
                startActivity(intent)
            }
        }
        ahadethRecyclerView.adapter = adapter
    }
}