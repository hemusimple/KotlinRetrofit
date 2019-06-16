package com.c.kotlinexamples.rest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServerClient {
    companion object {
        val BaseUrl = "http://192.168.100.108:3000"         // BaseUrl can be replace with new one.
        fun getRestclient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }
    }
}