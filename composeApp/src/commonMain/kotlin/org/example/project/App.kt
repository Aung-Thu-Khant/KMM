package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import kmm.composeapp.generated.resources.Res
import kmm.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showContent by remember { mutableStateOf(false) }
    var userNameError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }
    MaterialTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
        ){
            if(showContent){
                //Navigate to Home Screen
                HomePage(userName)
            }else{
                Column(
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Image(
                        painter = painterResource(Res.drawable.compose_multiplatform),
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = userName,
                        onValueChange = {
                            userName = it
                            userNameError = it.isEmpty()
                        },
                        label = { Text("Username") },
                        isError = userNameError,
                        modifier = Modifier.fillMaxWidth()
                    )
                    if(userNameError){
                        Text("Username is required", color = MaterialTheme.colors.error)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    TextField(
                        value = password,
                        onValueChange = {
                            password = it
                            passwordError = it.isEmpty()
                        },
                        label = { Text("Password") },
                        isError = passwordError,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )
                    if(passwordError){
                        Text("Password is required", color = MaterialTheme.colors.error)
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        userNameError = userName.isEmpty()
                        passwordError = password.isEmpty()
                        if(!userNameError && !passwordError){
                            showContent = true
                        }else{
                            showContent = false
                        }
                    }) {
                        Text("Login")
                    }

                }
            }

        }

    }
}