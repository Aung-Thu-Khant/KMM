package org.example.project.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.example.project.Network.ApiInterface
import org.example.project.model.UserItem

class UserViewModel: ViewModel() {
    private val apiInterface = ApiInterface()
    val users = MutableStateFlow<List<UserItem>>(emptyList())
    init {
        fetchUser()
    }
    private fun fetchUser(){
        viewModelScope.launch {
            users.value = apiInterface.getUsers()
        }
    }
}