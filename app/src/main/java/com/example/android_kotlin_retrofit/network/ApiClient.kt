package com.example.android_kotlin_retrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private val BASE_URL = "https://api.github.com/"
    private var retrofit: Retrofit? = null

    private val client: Retrofit?
        get() {

            if (retrofit == null) {
                retrofit =
                    Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return retrofit
        }

    val apiService: ApiService?
        get() = client?.create(ApiService::class.java)
}
