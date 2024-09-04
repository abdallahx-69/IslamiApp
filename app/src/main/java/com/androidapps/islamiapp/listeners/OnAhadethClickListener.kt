package com.androidapps.islamiapp.listeners

import com.androidapps.islamiapp.adapters.AhadethNamesAdapter

interface OnAhadethClickListener {
    fun onAhadethClick(ahadeth: AhadethNamesAdapter.Ahadeth, position: Int)
}