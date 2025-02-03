package org.example.project.Network

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.project.model.PostItem
import org.example.project.model.UserItem

class ApiInterface {
    private val client = HttpClient {
        install(ContentNegotiation){
            json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                }
            )
        }
        install(Logging){
            level = LogLevel.BODY
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 30000 // 15 seconds
            connectTimeoutMillis = 10000 // 10 seconds
            socketTimeoutMillis = 30000 // 15 seconds
        }
    }

    suspend fun getUsers(): List<UserItem>{
        return client.get("https://jsonplaceholder.typicode.com/users").body()
    }

    suspend fun getPosts(): List<PostItem>{
        return client.get("https://jsonplaceholder.typicode.com/posts").body()
    }



}




//ContentNegotiation
//Logging