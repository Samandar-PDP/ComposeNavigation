package uz.digital.jetpackwallpaper.ui.view.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.digital.jetpackwallpaper.ui.view.component.BottomBar
import uz.digital.jetpackwallpaper.ui.view.screen.BottomBarScreen
import uz.digital.jetpackwallpaper.ui.view.screen.MainNavGraph

@Composable
fun MainScreen(navHostController: NavHostController = rememberNavController()) {
    var text by remember {
        mutableStateOf("")
    }

    var isFabVisible by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(key1 = navHostController) {
        navHostController.currentBackStackEntryFlow.collect {
            isFabVisible = it.destination.route == BottomBarScreen.Home.route
            when (it.destination.route) {
                BottomBarScreen.Home.route -> {
                    text = "Home"
                }
                BottomBarScreen.Search.route -> {
                    text = "Search"
                }
                BottomBarScreen.Favorite.route -> {
                    text = "Favorite"
                }
                BottomBarScreen.Profile.route -> {
                    text = "Profile"
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = text) }
            )
        },
        bottomBar = { BottomBar(navHostController = navHostController) },
        floatingActionButton = {
            AnimatedVisibility(
                visible = isFabVisible,
                enter = fadeIn(animationSpec = tween(500)),
                exit = fadeOut(animationSpec = tween(500))
            ) {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
            }
        }
    ) {
        MainNavGraph(navHostController = navHostController)
    }
}