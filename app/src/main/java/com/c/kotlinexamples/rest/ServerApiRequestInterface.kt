package com.c.kotlinexamples.rest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface ServerApiRequestInterface {
    @GET("/listUsers")
    fun getContacts(): Call<ResponseBody>
}