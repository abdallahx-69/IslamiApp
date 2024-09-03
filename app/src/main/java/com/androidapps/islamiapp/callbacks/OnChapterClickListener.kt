package com.androidapps.islamiapp.callbacks

interface OnChapterClickListener {
    fun onChapterClick(chapters: Pair<String, Int>, position: Int)
}