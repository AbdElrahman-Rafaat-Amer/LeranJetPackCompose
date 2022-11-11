package com.abdelrahman.rafaat.firstjetpackcomposeapp.gym

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GymViewModel(private val stateHandel: SavedStateHandle) : ViewModel() {
    var gymState by mutableStateOf(restoreFavoriteGyms())

    private fun getGyms() = listOfGyms

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

    private fun restoreFavoriteGyms(): List<Gym> {
        val gyms = getGyms()
        stateHandel.get<List<Int>>(FAV_KEY)?.let {
            it.forEach { gymID ->
                gyms.find { gym -> gym.id == gymID }?.isFavorite = true
            }
        }
        return gyms
    }

    companion object {
        private const val FAV_KEY = "Favorite_Key"
    }
}