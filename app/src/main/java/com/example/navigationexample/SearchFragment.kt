package com.example.navigationexample

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigationexample.databinding.FragmentExampleBinding
import com.example.navigationexample.ui.base.BaseFragment


class SearchFragment : BaseFragment<FragmentExampleBinding>(bindingInflater =FragmentExampleBinding::inflate ) {

    override fun initView() {
        Log.e("log", "...SUCCESS... }")
    }



}