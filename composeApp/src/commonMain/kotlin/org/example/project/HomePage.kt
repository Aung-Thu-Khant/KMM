package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmm.composeapp.generated.resources.Res
import kmm.composeapp.generated.resources.img_five
import kmm.composeapp.generated.resources.img_four
import kmm.composeapp.generated.resources.img_one
import kmm.composeapp.generated.resources.img_three
import kmm.composeapp.generated.resources.img_two
import org.example.project.model.UserItem
import org.example.project.viewmodel.UserViewModel
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomePage(username: String) {
    val userViewModel : UserViewModel = remember { UserViewModel() }
    val users by userViewModel.users.collectAsState()
    LazyColumn (
        modifier = Modifier.fillMaxSize()
    ){
        items(users){
            UserItemView(it)
        }
    }
}

@Composable
fun UserItemView(user: UserItem){
    Column(
        modifier = Modifier.padding(12.dp)
    ){
        Text(
            text = user.name,
            style = MaterialTheme.typography.h6
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = user.email,
            style = MaterialTheme.typography.h6
        )
    }
}



