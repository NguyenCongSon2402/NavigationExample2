package com.example.navigationexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.navigationexample.constants.BASE_IMG
import com.example.navigationexample.databinding.FragmentDetailBinding
import com.example.navigationexample.network.model.Items

class DetailFragment : Fragment() {
    private val args: DetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        val receivedDetailMovie = args.detailMovie
        receivedDetailMovie?.let { initView(receivedDetailMovie) }

        return binding.root
    }

    private fun initView(items: Items) {
        Glide.with(this).load(BASE_IMG + items.thumbUrl).centerCrop().into(binding.imageViewThumb)
        binding.textViewTime.text = items.time
        binding.textViewTitle.text = items.name
        binding.textViewType.text = items.type
        binding.textViewOriginName.text = items.originName
    }

}