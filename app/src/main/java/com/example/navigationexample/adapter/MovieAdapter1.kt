package com.example.navigationexample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.navigationexample.R
import com.example.navigationexample.constants.BASE_IMG
import com.example.navigationexample.databinding.ItemPosterBinding
import com.example.navigationexample.network.model.Items
import com.example.navigationexample.ui.base.BaseListAdapter

class MovieAdapter1 : BaseListAdapter<Items, ItemPosterBinding>() {
    override fun createBinding(parent: ViewGroup): ItemPosterBinding {
        return ItemPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        super.onBindViewHolder(holder, position)
        val currentItem = getItem(position)
        val binding = holder.binding
        Glide.with(binding.posterImage).load(BASE_IMG+currentItem.thumbUrl).transform(CenterCrop())
            .into(binding.posterImage)
        binding.posterItem.clipToOutline = true
    }

}


