package com.androidapps.islamiapp.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidapps.islamiapp.R
import com.androidapps.islamiapp.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private lateinit var binding: FragmentSebhaBinding
    private var counter = 0
    private var currentIndex = 0
    private lateinit var azkarList: MutableList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.idTsabehatText.text = azkarList[0]
        onSebhaClick()
    }

    private fun onSebhaClick() {
        binding.idBodyOfSebhaImage.setOnClickListener {
            binding.idBodyOfSebhaImage.rotation += (360 / 33).toFloat()
            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) {
                    ++currentIndex
                } else {
                    0
                }
                binding.idTsabehatText.text = azkarList[currentIndex]
            }
            binding.idNumberOfTsabehatNumber.text = counter.toString()
        }
    }

}