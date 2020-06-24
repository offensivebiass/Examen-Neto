package com.alexfrias.examenneto.api

import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.reflect.KClass

class ApiClient {

    companion object {
        val BASE_URL = "http://157.245.227.216:3000/api/"

        fun getClient(classType: KClass<*>, context: Context): Any? {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val oktHttpClient = OkHttpClient.Builder()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(oktHttpClient.build())
                .build().create(classType.java)
        }
    }

}