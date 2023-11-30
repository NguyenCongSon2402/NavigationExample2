package com.example.navigationexample.network

import com.example.navigationexample.network.model.Home
import retrofit2.Response
import retrofit2.http.GET

interface MovieApi {
    @GET("/v1/api/home")
    suspend fun getHome(): Response<Home>
}