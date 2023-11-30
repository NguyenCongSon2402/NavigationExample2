package com.example.navigationexample.network

class ResultData <out T>(
    val status: Status,
    val data : T? = null,
    val message: String? = null
){
    enum class Status{
        SUCCESS, FAILED, LOADING
    }

    companion object{
        fun <T> success(data: T) = ResultData<T>(Status.SUCCESS, data, message = null)
        fun <T> loading (data:T? = null) = ResultData<T>(Status.LOADING, data, message = null)
        fun <T> failed(data:T? = null, msg:String) = ResultData<T>(Status.FAILED, data, message = msg)
    }
}