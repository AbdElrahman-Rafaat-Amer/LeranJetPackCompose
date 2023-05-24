package com.abdelrahman.rafaat.firstjetpackcomposeapp.network


import com.abdelrahman.rafaat.firstjetpackcomposeapp.gym.Gym
import retrofit2.Call
import retrofit2.http.GET

interface GymAPiService {
    @GET("gyms.json")
    fun getGyms(): Call<List<Gym>>
}