package com.example.navigationexample.ui.base

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T: ViewBinding>(private val bindingInflater: (bindingInflater: LayoutInflater) -> T): Fragment(){
    private var _binding: T? = null
    protected val binding get() = _binding!!
    val fragmentName: String by lazy { this.javaClass.simpleName }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("fragmentName", "onCreate-${fragmentName}")

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("fragmentName", "onCreateView-${fragmentName}")
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("fragmentName", "onViewCreated-${fragmentName}")
        initView()
    }

    override fun onPause() {
        super.onPause()
        Log.e("fragmentName", "onPause-${fragmentName}")

    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("fragmentName", "onDestroyView-${fragmentName}")

    }
    abstract fun initView()


    override fun onDestroy() {
        Log.e("fragmentName", "onDestroy-${fragmentName}")
        super.onDestroy()
        _binding = null
    }


}