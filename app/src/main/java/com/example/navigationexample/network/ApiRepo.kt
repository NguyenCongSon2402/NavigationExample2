package com.example.navigationexample.network

import com.example.navigationexample.network.model.Home
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepo @Inject constructor(private val apiDatasource: ApiDatasource) {
    suspend fun getALlMovie(): Flow<ResultData<Home>> {
        return flow {
            emit(safeApi {
                apiDatasource.getAllMovie()
            })
        }.flowOn(
            Dispatchers.IO
        )
    }

    private suspend fun <T> safeApi(apiCall: suspend () -> Response<T>): ResultData<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                if (response.body() != null && response.code() != 204) {
                    return ResultData.success(response.body()!!)
                }
            } else {
                val code = response.code()
                if (code == 400) {
                    return ResultData.failed(msg = "Lỗi 400")
                }
                return ResultData.failed(msg = "Có lỗi xảy ra")
            }
            return ResultData.loading()
        } catch (e: Exception) {
            return ResultData.failed(msg = "Có lỗi xảy ra, vui lòng thử lại")
        }
    }
}