package com.example.navigationexample.network

import com.example.navigationexample.network.model.Home
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
// Lớp ApiDatasource để đóng gói các cuộc gọi mạng
class ApiDatasource @Inject constructor(private val movieApi: MovieApi) {
    // Phương thức này thực hiện cuộc gọi mạng để lấy danh sách kết quả dữ liệu
    suspend fun getAllMovie(): Response<Home> {
        return movieApi.getHome()
    }
}