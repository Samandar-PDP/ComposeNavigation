package uz.digital.jetpackwallpaper.ui.view.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import uz.digital.jetpackwallpaper.ui.view.home.MainScreen
import uz.digital.jetpackwallpaper.util.Graph

@Composable
fun RootNavigation(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        route = Graph.ROOT,
        startDestination = Graph.SPLASH
    ) {
        splashNavGraph(navHostController = navHostController)
        composable(route = Graph.MAIN) {
            MainScreen()
        }
    }
}