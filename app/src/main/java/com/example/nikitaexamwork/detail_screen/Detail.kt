package com.example.nikitaexamwork.detail_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nikitaexamwork.BackToMainScreen
import com.example.nikitaexamwork.SelectSpecificUser
import com.example.nikitaexamwork.data.Data
import com.example.nikitaexamwork.data.DataHolder
import com.example.nikitaexamwork.databinding.FragmentDetailBinding

class Detail : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)

        val backToMainScreen = requireActivity() as BackToMainScreen


        binding.image.setImageResource(DataHolder.selectedPerson.pictureRes)
        binding.name.text = DataHolder.selectedPerson.name + " " + DataHolder.selectedPerson.surname
        binding.achivements.text = DataHolder.selectedPerson.details.achievements.toString()

        binding.back.setOnClickListener {
            backToMainScreen.backScreen()
        }

        return binding.root
    }

}