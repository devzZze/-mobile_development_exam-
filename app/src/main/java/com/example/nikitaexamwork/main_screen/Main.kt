package com.example.nikitaexamwork.main_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nikitaexamwork.SelectSpecificUser
import com.example.nikitaexamwork.databinding.FragmentDetailBinding
import com.example.nikitaexamwork.databinding.FragmentMainBinding
import com.example.nikitaexamwork.main_screen.adapter.RecyclerAdapter

interface windowManager{
    fun openTransactionWindow()
}
class Main : Fragment(), windowManager {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        val selectSpecificUser = requireActivity() as SelectSpecificUser

        adapter = RecyclerAdapter(object : windowManager {
            override fun openTransactionWindow() {
                selectSpecificUser.openDetailScreen()
            }
        })

        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(context)

        binding.recyclerMainScreen.layoutManager = layoutManager
        binding.recyclerMainScreen.adapter = adapter

        return binding.root
    }

    override fun openTransactionWindow() {
        TODO("Not yet implemented")
    }

}