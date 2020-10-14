package com.longjunhao.pagingwithnetworksample.api

import com.longjunhao.pagingwithnetworksample.data.HomeActicleResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * .WanandroidApi
 *
 * @author Admitor
 * @date 2020/09/23
 */
interface WanandroidApi {

    @GET("/article/list/{page}/json")
    suspend fun getHomeActicle(
        @Path("page") page: Int
    ): HomeActicleResponse

    companion object {
        private const val BASE_URL = "https://www.wanandroid.com/"

        fun create(): WanandroidApi {
            val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WanandroidApi::class.java)
        }
    }
}