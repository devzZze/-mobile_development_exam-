package com.example.nikitaexamwork.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nikitaexamwork.data.Data
import com.example.nikitaexamwork.data.DataHolder
import com.example.nikitaexamwork.data.DataHolder.dataList
import com.example.nikitaexamwork.databinding.MainItemBinding
import com.example.nikitaexamwork.main_screen.windowManager

class RecyclerAdapter(private val windowManager: windowManager): RecyclerView.Adapter<RecyclerAdapter.MainViewHolder>() {

    private var arrayList: MutableList<Data> = dataList as MutableList<Data>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MainItemBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val person = arrayList[position]

        holder.itemView.setOnClickListener {
            DataHolder.selectedPerson = person
            windowManager.openTransactionWindow()
        }

        with(holder.binding) {
            image.setImageResource(person.pictureRes)
            name.text = person.name + " " + person.surname
            shortDesc.text = person.minimalInfo
        }
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    class MainViewHolder (var binding: MainItemBinding): RecyclerView.ViewHolder(binding.root)

}