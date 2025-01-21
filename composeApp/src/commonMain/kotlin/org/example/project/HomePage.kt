package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import org.jetbrains.compose.resources.painterResource

@Composable
fun HomePage(username: String) {

    //Sample Movie list
    val sampleMovies = listOf(
        Movie("ဇော်ဂနီ", Res.drawable.img_one),
        Movie("သားတော်မောင်", Res.drawable.img_two),
        Movie("မင်းမျက်ဝန်း", Res.drawable.img_three),
        Movie("အပြုံးမင်းသား", Res.drawable.img_four),
        Movie("စိတ်စေတနာ", Res.drawable.img_five),
    )
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))
        Text("Welcome $username")
        Spacer(Modifier.height(16.dp))
        MovieList(sampleMovies)
    }
}

@Composable
fun MovieItem(movie: Movie){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ){
        Image(
            painter = painterResource(movie.image),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = movie.title,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

// Horizontal list of movies
@Composable
fun MovieList(movies: List<Movie>){
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        items(movies){ movie ->
            MovieItem(movie)
        }
    }
}
