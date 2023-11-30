package com.example.navigationexample.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding>(private val getBinding: (LayoutInflater) -> T) :
    AppCompatActivity() {
    protected lateinit var binding: T
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getBinding.invoke(layoutInflater)
        setContentView(binding.root)
        initViews()
        getData()
    }

    open fun getData() {}

    abstract fun initObserve()

    abstract fun initViews()
}