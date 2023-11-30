package com.example.navigationexample.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationexample.network.ResultData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

abstract class BaseViewModel : ViewModel() {
    val errorMessage: MutableLiveData<String> = MutableLiveData()
    fun launch(function: suspend () -> Unit) {
        viewModelScope.launch {
            try {
                function.invoke()
            } catch (e: Exception) {
                errorMessage.postValue(Constant.System_error)
            }
        }
    }
}
object Constant {
    const val System_error = "System error"
}