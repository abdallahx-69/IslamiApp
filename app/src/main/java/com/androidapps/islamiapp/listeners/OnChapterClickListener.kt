package com.androidapps.islamiapp.listeners

interface OnChapterClickListener {
    fun onChapterClick(chapters: Pair<String, Int>, position: Int)
}