package com.example.navigationexample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationexample.network.ApiRepo
import com.example.navigationexample.network.ResultData
import com.example.navigationexample.network.model.Home
import com.example.navigationexample.ui.base.BaseFragmentViewModel
import com.example.navigationexample.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val apiRepo: ApiRepo) : BaseFragmentViewModel() {
    private val _stateListMovie = MutableLiveData<ResultData<Home>>()
    val stateListMovie: LiveData<ResultData<Home>> = _stateListMovie

    fun getAllMovie() {
        launch {
            _stateListMovie.value = ResultData.loading()
            apiRepo.getALlMovie().collect() {
                if (it.status == ResultData.Status.SUCCESS) {
                    if (it.data != null) {
                        _stateListMovie.value = ResultData.success(it.data) // data results
                    } else {
                        _stateListMovie.value = ResultData.failed(msg = "Data null")
                    }
                } else {
                    _stateListMovie.value = ResultData.failed(msg = "Call failed")
                }
            }
        }
    }
}