package com.example.profilelistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.profilelistcompose.ui.theme.ProfileListComposeTheme
import com.example.profilelistcompose.ui.theme.lightGreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileListComposeTheme {
                MainScreen(userProfileList)
            }
        }
    }
}

@Composable
fun MainScreen(userProfiles: List<UserProfile>) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn {
                items(userProfiles) { userProfile ->
                    ProfileCard(userProfile = userProfile)
                }
            }
        }
    }
}

@Composable
fun AppBar() {
    TopAppBar(
        title = { Text("Message") },
        navigationIcon = {
            Icon(Icons.Default.Home, "Home", modifier = Modifier.padding(start = 12.dp))
        }
    )
}

@Composable
fun ProfileCard(userProfile: UserProfile) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            ProfilePicture(userProfile.drawableId, userProfile.status)
            ProfileContent(userProfile.name, userProfile.status)
        }
    }
}

@Composable
fun ProfilePicture(drawableId: Int, status: Boolean) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, if (status) Color.Green else Color.Red),
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(
            painter = rememberImagePainter(drawableId),
            contentDescription = "Profile Image",
            modifier = Modifier.size(72.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileContent(name: String, status: Boolean) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Text(text = name, style = MaterialTheme.typography.h5)
        CompositionLocalProvider(LocalContentAlpha provides if(status) 1f else ContentAlpha.medium) {
            Text(text = if(status) "Active now" else "Offline", style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun UserProfileDetailScreen(userProfile: UserProfile = userProfileList[0]) {
    Scaffold(topBar = { AppBar() }) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            ProfileCard(userProfile = userProfile)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileListComposeTheme {
        MainScreen(userProfileList)
    }
}