package com.example.navigationexample.di

import com.example.navigationexample.BuildConfig
import com.example.navigationexample.network.ApiDatasource
import com.example.navigationexample.network.ApiRepo
import com.example.navigationexample.network.MovieApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://ophim1.com")
        .client(okHttpClient)
        .build()
    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi =
        retrofit.create(MovieApi::class.java)


    @Singleton
    @Provides
    fun provideApiRepo(apiDatasource: ApiDatasource): ApiRepo {
        return ApiRepo(apiDatasource)
    }

    @Singleton
    @Provides
    fun provideApiDatasource(movieApi: MovieApi): ApiDatasource {
        return ApiDatasource(movieApi)
    }

}