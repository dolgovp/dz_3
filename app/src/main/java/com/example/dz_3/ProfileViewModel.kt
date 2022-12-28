package com.example.dz_3

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dz_3.data.User
import com.example.dz_3.data.repository.UserRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userRepository: UserRepository = Graph.userRepository
) : ViewModel(){
    private val _state = MutableStateFlow(ProfileViewState())
    val state: StateFlow<ProfileViewState>
        get() = _state

    init {
        viewModelScope.launch {
            Log.d(TAG, "Userrrrrrrr"+userRepository.user("Pavel").toString())
            delay(2000L)
            _state.update {
                ProfileViewState(user = userRepository.user("Pavel"))
            }
            Log.d(TAG, "User"+ProfileViewState().user.toString())
        }
        loadUser()
    }
    private fun loadUser(){
        val user = User(
            1,
            "https://pitbiker.ru/wa-data/public/photos/64/00/64/64.970.jpg",
            "Pavel",
            "Moscow",
            "89038031274",
            "dolgoff@gmail.com",
            "23.09.2002",
            "Мужской",
            "@dolgovpa",
            "id5398394"
        )
        viewModelScope.launch {
            userRepository.addUser(user)
        }
    }
}
data class ProfileViewState(
    val user: User? = null
)