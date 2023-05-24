package com.abdelrahman.rafaat.firstjetpackcomposeapp.gym

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.abdelrahman.rafaat.firstjetpackcomposeapp.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class GymViewModel(private val stateHandel: SavedStateHandle) : ViewModel() {
    var gymState by mutableStateOf(emptyList<Gym>())
    private lateinit var apiCall: Call<List<Gym>>

    init {
        getGyms()
    }

    private fun getGyms() {
        apiCall = RetrofitHelper.retrofitHelper.getGyms()
        //This way make call on backGround thread
        apiCall.enqueue(object : Callback<List<Gym>> {
            override fun onResponse(call: Call<List<Gym>>, response: Response<List<Gym>>) {
                response.body()?.let {
                    gymState = it.restoreFavoriteGyms()
                }
            }

            override fun onFailure(call: Call<List<Gym>>, t: Throwable) {
                Log.i("NetworkError", "onFailure: error--------> ${t.message}")
            }
        })

        /*      //This way cause error android.os.NetworkOnMainThreadException because it make call onMainThread
              apiService.getGyms().execute().body()?.let {
                  gymState = it.restoreFavoriteGyms()
              }*/
    }

    fun addToFavorite(gymId: Int) {
        val gymList = gymState.toMutableList()
        val gymIndex = gymList.indexOfFirst { it.id == gymId }
        gymList[gymIndex] =
            gymList[gymIndex].copy(isFavorite = !gymList[gymIndex].isFavorite)
        storeFavoriteGym(gymList[gymIndex])
        gymState = gymList
    }

    private fun storeFavoriteGym(gym: Gym) {
        val favoriteList = stateHandel.get<List<Int>>(FAV_KEY).orEmpty().toMutableList()
        if (gym.isFavorite) favoriteList.add(gym.id)
        else favoriteList.remove(gym.id)
    }

    private fun List<Gym>.restoreFavoriteGyms(): List<Gym> {
        stateHandel.get<List<Int>>(FAV_KEY)?.let {
            it.forEach { gymID ->
                this.find { gym -> gym.id == gymID }?.isFavorite = true
            }
        }
        return this
    }

    override fun onCleared() {
        super.onCleared()
        apiCall.cancel()
    }

    companion object {
        private const val FAV_KEY = "Favorite_Key"
    }
}