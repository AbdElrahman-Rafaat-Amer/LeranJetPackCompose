package com.abdelrahman.rafaat.firstjetpackcomposeapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val API_URL = "https://gyms-486dd-default-rtdb.firebaseio.com/"
    val retrofitHelper = getRetrofitClient().create(GymAPiService::class.java)

    private fun getRetrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}