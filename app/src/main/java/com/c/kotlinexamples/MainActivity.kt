package com.c.kotlinexamples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.c.kotlinexamples.rest.ServerRequest

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ServerRequest.getListofRecords(object :ServerRequest.GetResponseListner{
           override fun onSuccess(response: String) {
               //Here need to convertstream to string.
               //To  get the proper response.
           Toast.makeText(this@MainActivity,response,Toast.LENGTH_LONG).show()
           }
           override fun onFailure(error: String) {
               Toast.makeText(this@MainActivity,error,Toast.LENGTH_LONG).show()
           }
       })
    }
}
