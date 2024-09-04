package com.androidapps.islamiapp.fragments.ahadeth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.androidapps.islamiapp.R
import com.androidapps.islamiapp.adapters.AhadathContentAdapter
import com.androidapps.islamiapp.utils.Constants

class AhadethContentActivity : AppCompatActivity() {
    private var ahadethName: String? = null
    private lateinit var ahadethContent: String
    private lateinit var ahadethContentRecyclerView: RecyclerView
    private lateinit var adapter: AhadathContentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ahadeth_content)
        initParams()
        initViews()
    }

    private fun initViews() {
        ahadethContentRecyclerView = findViewById(R.id.id_ahadethContentRecyclerView)
        adapter = AhadathContentAdapter(ahadethContent.split("\n"))
        ahadethContentRecyclerView.adapter = adapter
    }

    private fun initParams() {
        ahadethName = intent.getStringExtra(Constants.HADETH_TITLE_EXTRA)
        ahadethContent = intent.getStringExtra(Constants.HADETH_Content_EXTRA).toString()
    }
}
