package com.c.kotlinexamples.rest

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.InputStream

import java.nio.charset.Charset


class ServerRequest {

    interface GetResponseListner {
        fun onSuccess(response: String)
        fun onFailure(error: String)
    }

    companion object {
        fun  getListofRecords(listner:GetResponseListner){
            val client=ServerClient.getRestclient()
            val call=client.create(ServerApiRequestInterface::class.java)
            dispatchResponse(call.getContacts(),listner)
        }

        fun  dispatchResponse(call:Call<ResponseBody>,responseListner:GetResponseListner){
            call.enqueue(object:Callback<ResponseBody>{
                override fun onResponse(call: Call<ResponseBody>?, res: Response<ResponseBody>?) {
                   if(res?.isSuccessful!!){
                       responseListner.onSuccess(convertStreamTostring(res.body().byteStream()))
                   }
                }
                override fun onFailure(call: Call<ResponseBody>?, t: Throwable?) {
                    responseListner.onFailure(t?.localizedMessage!!)
                }
            })
        }

        fun convertStreamTostring(inputStream:InputStream):String{
            return  inputStream.bufferedReader(Charset.defaultCharset()).use {
                it.readText()
            }
        }
    }
}