package com.explore.stackoverflow.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.explore.stackoverflow.data.Topic
import com.explore.stackoverflow.databinding.ItemMainBinding
import com.explore.stackoverflow.ui.main.MainAdapter.MainViewHolder

class MainAdapter(private val list: List<Topic>, private val listener: OnItemClick) :
    Adapter<MainViewHolder>() {

    interface OnItemClick {
        fun onClick(item: Topic)
    }

    inner class MainViewHolder(binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding = binding
        fun bind(item: Topic) {
            binding.item = item
            binding.topicItem.setOnClickListener { listener.onClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMainBinding.inflate(inflater)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }
}