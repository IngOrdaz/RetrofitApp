package com.nbd.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nbd.retrofitapp.remote.PokemonEntry
import com.nbd.retrofitapp.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit=RetrofitBuilder.create().getPokemonById("4")

        retrofit.enqueue(object:retrofit2.Callback<PokemonEntry>{
            override fun onResponse(call:Call<PokemonEntry>,response: Response<PokemonEntry>){
                val resBody=response.body()
                if (resBody != null) {
                    Log.d("retrofitresponse", "res:  ${resBody}")
                    Log.d("retrofitresponse", "name:  ${resBody.name}")

                    for (stat in resBody.stats) {
                        Log.d("retrofitresponse", "${stat.stat.stat_value}:${stat.base_stat}")
                    }
                    Log.d("retrofitresponse","type: ${resBody.types[0].type.name}")
                    Log.d("retrofitresponse","front_default: ${resBody.sprites}")
                }
            }

            override fun onFailure(call: Call<PokemonEntry>,t:Throwable){
                Log.e("retrofitresponse","error: ${ t.message }")
            }
        })
    }
}